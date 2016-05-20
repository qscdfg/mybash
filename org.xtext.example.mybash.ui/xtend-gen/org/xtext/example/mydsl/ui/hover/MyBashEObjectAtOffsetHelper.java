package org.xtext.example.mydsl.ui.hover;

import com.google.common.base.Objects;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;

@SuppressWarnings("all")
public class MyBashEObjectAtOffsetHelper extends EObjectAtOffsetHelper {
  @Override
  public INode getCrossReferenceNode(final XtextResource resource, final ITextRegion region) {
    IParseResult parseResult = resource.getParseResult();
    boolean _notEquals = (!Objects.equal(parseResult, null));
    if (_notEquals) {
      ICompositeNode _rootNode = parseResult.getRootNode();
      int _offset = region.getOffset();
      ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(_rootNode, _offset);
      INode crossRefNode = this.findCrossReferenceNode(leaf);
      boolean _and = false;
      boolean _notEquals_1 = (!Objects.equal(crossRefNode, null));
      if (!_notEquals_1) {
        _and = false;
      } else {
        int _endOffset = crossRefNode.getEndOffset();
        int _offset_1 = region.getOffset();
        int _length = region.getLength();
        int _plus = (_offset_1 + _length);
        boolean _greaterEqualsThan = (_endOffset >= _plus);
        _and = _greaterEqualsThan;
      }
      if (_and) {
        return crossRefNode;
      }
    }
    return null;
  }
}
