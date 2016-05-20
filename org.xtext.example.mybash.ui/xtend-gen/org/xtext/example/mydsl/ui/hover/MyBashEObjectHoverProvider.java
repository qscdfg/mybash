package org.xtext.example.mydsl.ui.hover;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.xtext.example.mydsl.myBash.CommandName;
import org.xtext.example.mydsl.myBash.FollowWordOp;
import org.xtext.example.mydsl.myBash.ParameterExpansion;
import org.xtext.example.mydsl.myBash.ParameterProcessor;
import org.xtext.example.mydsl.myBash.SingleProcessor;

@SuppressWarnings("all")
public class MyBashEObjectHoverProvider extends DefaultEObjectHoverProvider {
  @Override
  public boolean hasHover(final EObject o) {
    if ((o instanceof ParameterProcessor)) {
      return true;
    }
    if ((o instanceof ParameterExpansion)) {
      return true;
    }
    if ((o instanceof CommandName)) {
      return true;
    }
    return super.hasHover(o);
  }
  
  @Override
  public String getFirstLine(final EObject o) {
    String _xblockexpression = null;
    {
      String result = null;
      String _innerGetFirstLine = this.innerGetFirstLine(o);
      result = _innerGetFirstLine;
      boolean _equals = Objects.equal(result, null);
      if (_equals) {
        String _firstLine = super.getFirstLine(o);
        result = _firstLine;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected String _innerGetFirstLine(final EObject object) {
    return null;
  }
  
  protected String _innerGetFirstLine(final SingleProcessor object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ParameterExpansion Operator : <b>");
    FollowWordOp _op = object.getOp();
    _builder.append(_op, "");
    _builder.append("</b>");
    return _builder.toString();
  }
  
  protected String _innerGetFirstLine(final ParameterExpansion object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ParameterExpansion : <b>");
    String _refName = MyBashEObjectHoverProvider.getRefName(object);
    _builder.append(_refName, "");
    _builder.append("</b>");
    return _builder.toString();
  }
  
  public static String getRefName(final EObject object) {
    String _xblockexpression = null;
    {
      EClass _eClass = object.eClass();
      EStructuralFeature refFeature = _eClass.getEStructuralFeature("ref");
      Object ref = object.eGet(refFeature);
      boolean _and = false;
      if (!(ref instanceof EObject)) {
        _and = false;
      } else {
        boolean _eIsProxy = ((EObject) ref).eIsProxy();
        boolean _not = (!_eIsProxy);
        _and = _not;
      }
      if (_and) {
        EClass _eClass_1 = ((EObject) ref).eClass();
        EStructuralFeature nameFeature = _eClass_1.getEStructuralFeature("name");
        Object _eGet = ((EObject) ref).eGet(nameFeature);
        return ((String) _eGet);
      }
      List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(object, refFeature);
      String _nodesString = null;
      if (_findNodesForFeature!=null) {
        _nodesString=MyBashEObjectHoverProvider.getNodesString(_findNodesForFeature);
      }
      _xblockexpression = _nodesString;
    }
    return _xblockexpression;
  }
  
  public static String getNodesString(final List<INode> nodes) {
    String _xblockexpression = null;
    {
      StringBuilder builder = new StringBuilder();
      for (final INode node : nodes) {
        String _text = node.getText();
        builder.append(_text);
      }
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
  
  public String innerGetFirstLine(final EObject object) {
    if (object instanceof ParameterExpansion) {
      return _innerGetFirstLine((ParameterExpansion)object);
    } else if (object instanceof SingleProcessor) {
      return _innerGetFirstLine((SingleProcessor)object);
    } else if (object != null) {
      return _innerGetFirstLine(object);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(object).toString());
    }
  }
}
