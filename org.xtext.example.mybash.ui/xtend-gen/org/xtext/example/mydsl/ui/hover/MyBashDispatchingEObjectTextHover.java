package org.xtext.example.mydsl.ui.hover;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class MyBashDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
  public static class EObjectRegion implements IRegion {
    private IRegion delegate;
    
    private EObject object;
    
    public EObjectRegion(final EObject object, final IRegion region) {
      this.delegate = region;
      this.object = object;
    }
    
    @Override
    public int getLength() {
      return this.delegate.getLength();
    }
    
    @Override
    public int getOffset() {
      return this.delegate.getOffset();
    }
    
    public EObject getModel() {
      return this.object;
    }
  }
  
  @Inject
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;
  
  @Inject
  private ILocationInFileProvider locationInFileProvider;
  
  @Override
  public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
    IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
    boolean _equals = Objects.equal(xtextDocument, null);
    if (_equals) {
      return null;
    }
    try {
      return xtextDocument.<IRegion>readOnly(
        new IUnitOfWork<IRegion, XtextResource>() {
          @Override
          public IRegion exec(final XtextResource state) throws Exception {
            boolean _equals = Objects.equal(state, null);
            if (_equals) {
              return null;
            }
            Pair<EObject, IRegion> element = MyBashDispatchingEObjectTextHover.this.getXtextElementAt(state, offset);
            boolean _notEquals = (!Objects.equal(element, null));
            if (_notEquals) {
              EObject _first = element.getFirst();
              IRegion _second = element.getSecond();
              return new MyBashDispatchingEObjectTextHover.EObjectRegion(_first, _second);
            } else {
              return null;
            }
          }
        });
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledException) {
        final OperationCanceledException e = (OperationCanceledException)_t;
        return null;
      } else if (_t instanceof OperationCanceledError) {
        final OperationCanceledError e_1 = (OperationCanceledError)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public Object getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
    boolean _equals = Objects.equal(hoverRegion, null);
    if (_equals) {
      return null;
    }
    IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
    boolean _equals_1 = Objects.equal(xtextDocument, null);
    if (_equals_1) {
      return null;
    }
    try {
      return xtextDocument.<Object>readOnly(new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource state) throws Exception {
          boolean _equals = Objects.equal(state, null);
          if (_equals) {
            return null;
          }
          if ((hoverRegion instanceof MyBashDispatchingEObjectTextHover.EObjectRegion)) {
            EObject _model = ((MyBashDispatchingEObjectTextHover.EObjectRegion)hoverRegion).getModel();
            return MyBashDispatchingEObjectTextHover.this.getHoverInfo(_model, textViewer, hoverRegion);
          }
          int _offset = hoverRegion.getOffset();
          Pair<EObject, IRegion> element = MyBashDispatchingEObjectTextHover.this.getXtextElementAt(state, _offset);
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(element, null));
          if (!_notEquals) {
            _and = false;
          } else {
            EObject _first = element.getFirst();
            boolean _notEquals_1 = (!Objects.equal(_first, null));
            _and = _notEquals_1;
          }
          if (_and) {
            EObject _first_1 = element.getFirst();
            return MyBashDispatchingEObjectTextHover.this.getHoverInfo(_first_1, textViewer, hoverRegion);
          }
          return null;
        }
      });
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledException) {
        final OperationCanceledException e = (OperationCanceledException)_t;
        return null;
      } else if (_t instanceof OperationCanceledError) {
        final OperationCanceledError e_1 = (OperationCanceledError)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public Pair<EObject, IRegion> getXtextElementAt(final XtextResource resource, final int offset) {
    EObject crossLinkedEObject = this.eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    boolean _notEquals = (!Objects.equal(crossLinkedEObject, null));
    if (_notEquals) {
      boolean _eIsProxy = crossLinkedEObject.eIsProxy();
      boolean _not = (!_eIsProxy);
      if (_not) {
        IParseResult parseResult = resource.getParseResult();
        boolean _notEquals_1 = (!Objects.equal(parseResult, null));
        if (_notEquals_1) {
          ICompositeNode _rootNode = parseResult.getRootNode();
          ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(_rootNode, offset);
          boolean _and = false;
          boolean _and_1 = false;
          boolean _notEquals_2 = (!Objects.equal(leafNode, null));
          if (!_notEquals_2) {
            _and_1 = false;
          } else {
            boolean _isHidden = leafNode.isHidden();
            _and_1 = _isHidden;
          }
          if (!_and_1) {
            _and = false;
          } else {
            int _offset = leafNode.getOffset();
            boolean _equals = (_offset == offset);
            _and = _equals;
          }
          if (_and) {
            ICompositeNode _rootNode_1 = parseResult.getRootNode();
            ILeafNode _findLeafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(_rootNode_1, (offset - 1));
            leafNode = _findLeafNodeAtOffset;
          }
          boolean _notEquals_3 = (!Objects.equal(leafNode, null));
          if (_notEquals_3) {
            ITextRegion leafRegion = leafNode.getTextRegion();
            int _offset_1 = leafRegion.getOffset();
            int _length = leafRegion.getLength();
            Region _region = new Region(_offset_1, _length);
            return Tuples.<EObject, IRegion>create(crossLinkedEObject, _region);
          }
        }
      } else {
        EObject o = this.eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
        boolean _notEquals_4 = (!Objects.equal(o, null));
        if (_notEquals_4) {
          ITextRegion region = this.locationInFileProvider.getSignificantTextRegion(o);
          int _offset_2 = region.getOffset();
          int _length_1 = region.getLength();
          Region region2 = new Region(_offset_2, _length_1);
          Region _region_1 = new Region(offset, 0);
          boolean _overlaps = TextUtilities.overlaps(region2, _region_1);
          if (_overlaps) {
            return Tuples.<EObject, IRegion>create(o, region2);
          }
        }
      }
    } else {
      EObject o_1 = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
      boolean _notEquals_5 = (!Objects.equal(o_1, null));
      if (_notEquals_5) {
        ITextRegion region_1 = this.locationInFileProvider.getSignificantTextRegion(o_1);
        int _offset_3 = region_1.getOffset();
        int _length_2 = region_1.getLength();
        Region region2_1 = new Region(_offset_3, _length_2);
        Region _region_2 = new Region(offset, 0);
        boolean _overlaps_1 = TextUtilities.overlaps(region2_1, _region_2);
        if (_overlaps_1) {
          return Tuples.<EObject, IRegion>create(o_1, region2_1);
        }
      }
    }
    return null;
  }
}
