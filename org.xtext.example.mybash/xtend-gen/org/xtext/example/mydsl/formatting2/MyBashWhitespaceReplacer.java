package org.xtext.example.mydsl.formatting2;

import com.google.common.base.Objects;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

@SuppressWarnings("all")
public class MyBashWhitespaceReplacer extends WhitespaceReplacer {
  public MyBashWhitespaceReplacer(final ITextSegment whitespace, final IHiddenRegionFormatting formatting) {
    super(whitespace, formatting);
  }
  
  @Override
  protected int computeNewLineCount(final ITextReplacerContext context) {
    IHiddenRegionFormatting _formatting = this.getFormatting();
    Integer newLineDefault = _formatting.getNewLineDefault();
    IHiddenRegionFormatting _formatting_1 = this.getFormatting();
    Integer newLineMin = _formatting_1.getNewLineMin();
    IHiddenRegionFormatting _formatting_2 = this.getFormatting();
    Integer newLineMax = _formatting_2.getNewLineMax();
    boolean _or = false;
    boolean _or_1 = false;
    boolean _notEquals = (!Objects.equal(newLineMin, null));
    if (_notEquals) {
      _or_1 = true;
    } else {
      boolean _notEquals_1 = (!Objects.equal(newLineDefault, null));
      _or_1 = _notEquals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _notEquals_2 = (!Objects.equal(newLineMax, null));
      _or = _notEquals_2;
    }
    if (_or) {
      boolean _and = false;
      ITextSegment _region = this.getRegion();
      if (!(_region instanceof IHiddenRegion)) {
        _and = false;
      } else {
        ITextSegment _region_1 = this.getRegion();
        boolean _isUndefined = ((IHiddenRegion) _region_1).isUndefined();
        _and = _isUndefined;
      }
      if (_and) {
        boolean _notEquals_3 = (!Objects.equal(newLineDefault, null));
        if (_notEquals_3) {
          return (newLineDefault).intValue();
        }
        boolean _notEquals_4 = (!Objects.equal(newLineMin, null));
        if (_notEquals_4) {
          return (newLineMin).intValue();
        }
        boolean _notEquals_5 = (!Objects.equal(newLineMax, null));
        if (_notEquals_5) {
          return (newLineMax).intValue();
        }
      } else {
        ITextSegment _region_2 = this.getRegion();
        int _lineCount = _region_2.getLineCount();
        int _minus = (_lineCount - 1);
        int _trailingNewLinesOfPreviousRegion = this.trailingNewLinesOfPreviousRegion();
        int lineCount = (_minus + _trailingNewLinesOfPreviousRegion);
        boolean _and_1 = false;
        boolean _notEquals_6 = (!Objects.equal(newLineMin, null));
        if (!_notEquals_6) {
          _and_1 = false;
        } else {
          _and_1 = ((newLineMin).intValue() > lineCount);
        }
        if (_and_1) {
          lineCount = (newLineMin).intValue();
        }
        boolean _and_2 = false;
        boolean _notEquals_7 = (!Objects.equal(newLineMax, null));
        if (!_notEquals_7) {
          _and_2 = false;
        } else {
          _and_2 = ((newLineMax).intValue() < lineCount);
        }
        if (_and_2) {
          lineCount = (newLineMax).intValue();
        }
        return lineCount;
      }
    }
    return 0;
  }
  
  @Override
  public int trailingNewLinesOfPreviousRegion() {
    ITextSegment _region = this.getRegion();
    int offset = _region.getOffset();
    if ((offset < 1)) {
      return 1;
    }
    ITextSegment _region_1 = this.getRegion();
    ITextRegionAccess _textRegionAccess = _region_1.getTextRegionAccess();
    String previous = _textRegionAccess.textForOffset((offset - 1), 1);
    boolean _equals = "\n".equals(previous);
    if (_equals) {
      return 1;
    }
    return 0;
  }
}
