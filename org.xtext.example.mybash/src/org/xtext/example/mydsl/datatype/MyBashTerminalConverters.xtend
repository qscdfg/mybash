package org.xtext.example.mydsl.datatype

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.impl.AbstractValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode

class MyBashTerminalConverters extends DefaultTerminalConverters {
	@ValueConverter(rule="NAME")
	def IValueConverter<String> NAME() {
		return new AbstractValueConverter<String>() {

			override toString(String value) throws ValueConverterException {
				if (value != null) {
					if (value.length > 0) {
						if (Character.isJavaIdentifierStart(value.charAt(0))) {
							for (var i = 1; i < value.length; i++) {
								if (!Character.isJavaIdentifierPart(value.charAt(i))) {
									throw new ValueConverterException("Invalid char [" + value.charAt(i) + "] .", null,
										null);
								}
							}
							return value;
						}
						throw new ValueConverterException("Invalid char [" + value.charAt(0) + "] .", null, null);
					}
					throw new ValueConverterException("Name must not be empty.", null, null);
				}
				throw new ValueConverterException("Name must not be empty.", null, null);
			}

			override toValue(String string, INode node) throws ValueConverterException {
				return string;
			}
		};
	}

	@ValueConverter(rule="VARIABLE")
	def IValueConverter<String> VARIABLE() {
		return new AbstractValueConverter<String>() {

			override toString(String value) throws ValueConverterException {
				if (value != null) {
					if (value.length > 0) {
						if (value.length == 1) {
							var d = "@$#0123456789?!*-_";
							var c = value.charAt(0)
							if (d.indexOf(c) != -1) {
								return "$" + value;
							}
						}
						if (Character.isJavaIdentifierStart(value.charAt(0))) {
							for (var i = 1; i < value.length; i++) {
								if (!Character.isJavaIdentifierPart(value.charAt(i))) {
									throw new ValueConverterException("Invalid char [" + value.charAt(i) + "] .", null,
										null);
								}
							}
							return "$" + value;
						}
						throw new ValueConverterException("Invalid char [" + value.charAt(0) + "] .", null, null);
					}
					throw new ValueConverterException("Name must not be empty.", null, null);
				}
				throw new ValueConverterException("Name must not be empty.", null, null);
			}

			override toValue(String string, INode node) throws ValueConverterException {
				return string.substring(1);
			}
		};
	}
}
