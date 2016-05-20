package org.xtext.example.mydsl.ui.hover

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.IRegion
import org.eclipse.jface.text.ITextViewer
import org.eclipse.jface.text.Region
import org.eclipse.jface.text.TextUtilities
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.xtext.example.mydsl.ui.hover.MyBashDispatchingEObjectTextHover.EObjectRegion

class MyBashDispatchingEObjectTextHover extends DispatchingEObjectTextHover {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	static class EObjectRegion implements IRegion {
		private IRegion delegate;
		private EObject object;

		new(EObject object, IRegion region) {
			delegate = region;
			this.object = object
		}

		override getLength() {
			delegate.length
		}

		override getOffset() {
			delegate.offset
		}

		def EObject getModel() {
			object
		}

	}

	override IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		var xtextDocument = XtextDocumentUtil.get(textViewer);
		if(xtextDocument == null)
			return null;
		// TODO this is being called on change in the UI-thread. Not a good idea to do such expensive stuff.
		// returning the region on a per token basis would be better.
		try {
			return xtextDocument.readOnly(
				new IUnitOfWork<IRegion, XtextResource>() {
					override IRegion exec(XtextResource state) throws Exception {
						// resource can be null e.g. read only zip/jar entry
						if(state == null) {
							return null;
						}
						var element = getXtextElementAt(state, offset);
						if(element != null) {
							return new EObjectRegion(element.first, element.second);
						} else {
							return null;
						}
					}
				}
			);
		} catch(OperationCanceledException e) {
			return null;
		} catch(OperationCanceledError e) {
			return null;
		}
	}

	override Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		if(hoverRegion == null)
			return null;
		var xtextDocument = XtextDocumentUtil.get(textViewer);
		if(xtextDocument == null)
			return null;
		try {
			return xtextDocument.readOnly(new IUnitOfWork<Object, XtextResource>() {

				override Object exec(XtextResource state) throws Exception {
					// resource can be null e.g. read only zip/jar entry
					if(state == null) {
						return null;
					}

					if(hoverRegion instanceof EObjectRegion) {
						return getHoverInfo(hoverRegion.model, textViewer, hoverRegion)
					}

					var element = getXtextElementAt(state, hoverRegion.getOffset());
					if(element != null && element.getFirst() != null) {
						return getHoverInfo(element.getFirst(), textViewer, hoverRegion);
					}
					return null;
				}
			});
		} catch(OperationCanceledException e) {
			return null;
		} catch(OperationCanceledError e) {
			return null;
		}
	}

	override Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		// check for cross reference
		var crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if(crossLinkedEObject != null) {
			if(!crossLinkedEObject.eIsProxy()) {
				var parseResult = resource.getParseResult();
				if(parseResult != null) {
					var leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
					if(leafNode != null && leafNode.isHidden() && leafNode.getOffset() == offset) {
						leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
					}
					if(leafNode != null) {
						var leafRegion = leafNode.getTextRegion();
						return Tuples.create(crossLinkedEObject, new Region(leafRegion.getOffset(), leafRegion.getLength()));
					}
				}
			} else {
				var o = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
				if(o != null) {
					var region = locationInFileProvider.getSignificantTextRegion(o);
					var region2 = new Region(region.getOffset(), region.getLength());
					if(TextUtilities.overlaps(region2, new Region(offset, 0)))
						return Tuples.create(o, region2);
				}
			}
		} else {
			var o = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
			if(o != null) {
				var region = locationInFileProvider.getSignificantTextRegion(o);

				var region2 = new Region(region.getOffset(), region.getLength());
				if(TextUtilities.overlaps(region2, new Region(offset, 0)))
					return Tuples.create(o, region2);
			}
		}
		return null;
	}

}
