package org.xtext.example.mydsl.ui.documentation;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.xtext.example.mydsl.myBash.CommandName;
import org.xtext.example.mydsl.myBash.FollowWordOp;
import org.xtext.example.mydsl.myBash.ParameterExpansion;
import org.xtext.example.mydsl.myBash.ReplaceProcessor;
import org.xtext.example.mydsl.myBash.SingleProcessor;

@SuppressWarnings("all")
public class MyBashDocumentationProvider implements IEObjectDocumentationProvider {
  @Override
  public String getDocumentation(final EObject o) {
    return this.innerGetDocumentation(o);
  }
  
  protected String _innerGetDocumentation(final EObject obj) {
    EClass _eClass = obj.eClass();
    String _name = _eClass.getName();
    return InputOutput.<String>println(_name);
  }
  
  protected String _innerGetDocumentation(final SingleProcessor obj) {
    StringConcatenation _builder = new StringConcatenation();
    FollowWordOp _op = obj.getOp();
    _builder.append(_op, "");
    return _builder.toString();
  }
  
  protected String _innerGetDocumentation(final ReplaceProcessor obj) {
    StringConcatenation _builder = new StringConcatenation();
    String _op = obj.getOp();
    _builder.append(_op, "");
    return _builder.toString();
  }
  
  protected String _innerGetDocumentation(final CommandName obj) {
    StringConcatenation _builder = new StringConcatenation();
    String _refName = MyBashDocumentationProvider.getRefName(obj);
    _builder.append(_refName, "");
    return _builder.toString();
  }
  
  protected String _innerGetDocumentation(final ParameterExpansion obj) {
    StringConcatenation _builder = new StringConcatenation();
    String _refName = MyBashDocumentationProvider.getRefName(obj);
    _builder.append(_refName, "");
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
        _nodesString=MyBashDocumentationProvider.getNodesString(_findNodesForFeature);
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
  
  public String innerGetDocumentation(final EObject obj) {
    if (obj instanceof CommandName) {
      return _innerGetDocumentation((CommandName)obj);
    } else if (obj instanceof ParameterExpansion) {
      return _innerGetDocumentation((ParameterExpansion)obj);
    } else if (obj instanceof ReplaceProcessor) {
      return _innerGetDocumentation((ReplaceProcessor)obj);
    } else if (obj instanceof SingleProcessor) {
      return _innerGetDocumentation((SingleProcessor)obj);
    } else if (obj != null) {
      return _innerGetDocumentation(obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
    }
  }
}
