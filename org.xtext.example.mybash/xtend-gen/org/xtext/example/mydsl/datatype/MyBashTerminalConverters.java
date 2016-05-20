package org.xtext.example.mydsl.datatype;

import com.google.common.base.Objects;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class MyBashTerminalConverters extends DefaultTerminalConverters {
  @ValueConverter(rule = "NAME")
  public IValueConverter<String> NAME() {
    return new AbstractValueConverter<String>() {
      @Override
      public String toString(final String value) throws ValueConverterException {
        boolean _notEquals = (!Objects.equal(value, null));
        if (_notEquals) {
          int _length = value.length();
          boolean _greaterThan = (_length > 0);
          if (_greaterThan) {
            char _charAt = value.charAt(0);
            boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart(_charAt);
            if (_isJavaIdentifierStart) {
              for (int i = 1; (i < value.length()); i++) {
                char _charAt_1 = value.charAt(i);
                boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt_1);
                boolean _not = (!_isJavaIdentifierPart);
                if (_not) {
                  char _charAt_2 = value.charAt(i);
                  String _plus = ("Invalid char [" + Character.valueOf(_charAt_2));
                  String _plus_1 = (_plus + "] .");
                  throw new ValueConverterException(_plus_1, null, 
                    null);
                }
              }
              return value;
            }
            char _charAt_1 = value.charAt(0);
            String _plus = ("Invalid char [" + Character.valueOf(_charAt_1));
            String _plus_1 = (_plus + "] .");
            throw new ValueConverterException(_plus_1, null, null);
          }
          throw new ValueConverterException("Name must not be empty.", null, null);
        }
        throw new ValueConverterException("Name must not be empty.", null, null);
      }
      
      @Override
      public String toValue(final String string, final INode node) throws ValueConverterException {
        return string;
      }
    };
  }
  
  @ValueConverter(rule = "VARIABLE")
  public IValueConverter<String> VARIABLE() {
    return new AbstractValueConverter<String>() {
      @Override
      public String toString(final String value) throws ValueConverterException {
        boolean _notEquals = (!Objects.equal(value, null));
        if (_notEquals) {
          int _length = value.length();
          boolean _greaterThan = (_length > 0);
          if (_greaterThan) {
            int _length_1 = value.length();
            boolean _equals = (_length_1 == 1);
            if (_equals) {
              String d = "@$#0123456789?!*-_";
              char c = value.charAt(0);
              int _indexOf = d.indexOf(c);
              boolean _notEquals_1 = (_indexOf != (-1));
              if (_notEquals_1) {
                return ("$" + value);
              }
            }
            char _charAt = value.charAt(0);
            boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart(_charAt);
            if (_isJavaIdentifierStart) {
              for (int i = 1; (i < value.length()); i++) {
                char _charAt_1 = value.charAt(i);
                boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt_1);
                boolean _not = (!_isJavaIdentifierPart);
                if (_not) {
                  char _charAt_2 = value.charAt(i);
                  String _plus = ("Invalid char [" + Character.valueOf(_charAt_2));
                  String _plus_1 = (_plus + "] .");
                  throw new ValueConverterException(_plus_1, null, 
                    null);
                }
              }
              return ("$" + value);
            }
            char _charAt_1 = value.charAt(0);
            String _plus = ("Invalid char [" + Character.valueOf(_charAt_1));
            String _plus_1 = (_plus + "] .");
            throw new ValueConverterException(_plus_1, null, null);
          }
          throw new ValueConverterException("Name must not be empty.", null, null);
        }
        throw new ValueConverterException("Name must not be empty.", null, null);
      }
      
      @Override
      public String toValue(final String string, final INode node) throws ValueConverterException {
        return string.substring(1);
      }
    };
  }
}
