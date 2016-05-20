package org.xtext.example.mydsl.ui.semantic.color;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.xtext.example.mydsl.myBash.Assignment;
import org.xtext.example.mydsl.myBash.CommandName;
import org.xtext.example.mydsl.myBash.CondBinaryExpression;
import org.xtext.example.mydsl.myBash.FunctionDefine;
import org.xtext.example.mydsl.myBash.ParameterExpansion;
import org.xtext.example.mydsl.myBash.Redirection;
import org.xtext.example.mydsl.ui.semantic.color.MyBashHighlightingConfiguration;

@SuppressWarnings("all")
public class MyBashSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
  @Override
  protected boolean highlightElement(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    return this.highlit(object, acceptor, cancelIndicator);
  }
  
  public void highlightFeatures(final IHighlightedPositionAcceptor acceptor, final EObject object, final String featuresName, final String... styleIds) {
    EClass _eClass = object.eClass();
    EStructuralFeature _eStructuralFeature = _eClass.getEStructuralFeature(featuresName);
    List<INode> children = NodeModelUtils.findNodesForFeature(object, _eStructuralFeature);
    for (final INode node : children) {
      this.highlightNode(acceptor, node, styleIds);
    }
  }
  
  protected boolean _highlit(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    return super.highlightElement(object, acceptor, cancelIndicator);
  }
  
  protected boolean _highlit(final CommandName commandName, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    FunctionDefine fd = commandName.getRef();
    boolean _notEquals = (!Objects.equal(fd, null));
    if (_notEquals) {
      String _name = fd.getName();
      boolean _notEquals_1 = (!Objects.equal(_name, null));
      if (_notEquals_1) {
        this.highlightFeatures(acceptor, commandName, "ref", MyBashHighlightingConfiguration.VALID_COMMAND_NAME_ID);
      } else {
        this.highlightFeatures(acceptor, commandName, "ref", MyBashHighlightingConfiguration.INVALID_COMMAND_NAME_ID);
      }
    }
    return false;
  }
  
  protected boolean _highlit(final CondBinaryExpression condExp, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    String operation = condExp.getOp();
    boolean _equals = "=~".equals(operation);
    if (_equals) {
      this.highlightFeatures(acceptor, condExp, "right", MyBashHighlightingConfiguration.REGULAR_EXPRESSION_ID);
    }
    return false;
  }
  
  protected boolean _highlit(final Redirection redirection, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    ICompositeNode _node = NodeModelUtils.getNode(redirection);
    this.highlightNode(acceptor, _node, MyBashHighlightingConfiguration.REDIRECT_ID);
    return true;
  }
  
  protected boolean _highlit(final FunctionDefine functionDefine, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    this.highlightFeatures(acceptor, functionDefine, "name", MyBashHighlightingConfiguration.FUNCTION_NAME_ID);
    return false;
  }
  
  protected boolean _highlit(final ParameterExpansion parameterExpansion, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    Assignment _ref = parameterExpansion.getRef();
    Assignment fd = ((Assignment) _ref);
    boolean _notEquals = (!Objects.equal(fd, null));
    if (_notEquals) {
      String _name = fd.getName();
      boolean _notEquals_1 = (!Objects.equal(_name, null));
      if (_notEquals_1) {
        this.highlightFeatures(acceptor, parameterExpansion, "ref", MyBashHighlightingConfiguration.VALID_VARIABLE_NAME_ID);
      } else {
        this.highlightFeatures(acceptor, parameterExpansion, "ref", MyBashHighlightingConfiguration.INVALID_VARIABLE_NAME_ID);
      }
    }
    return false;
  }
  
  public boolean highlit(final EObject commandName, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    if (commandName instanceof CommandName) {
      return _highlit((CommandName)commandName, acceptor, cancelIndicator);
    } else if (commandName instanceof ParameterExpansion) {
      return _highlit((ParameterExpansion)commandName, acceptor, cancelIndicator);
    } else if (commandName instanceof CondBinaryExpression) {
      return _highlit((CondBinaryExpression)commandName, acceptor, cancelIndicator);
    } else if (commandName instanceof FunctionDefine) {
      return _highlit((FunctionDefine)commandName, acceptor, cancelIndicator);
    } else if (commandName instanceof Redirection) {
      return _highlit((Redirection)commandName, acceptor, cancelIndicator);
    } else if (commandName != null) {
      return _highlit(commandName, acceptor, cancelIndicator);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(commandName, acceptor, cancelIndicator).toString());
    }
  }
}
