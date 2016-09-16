package nablarch.common.idgenerator.formatter;

import nablarch.common.idgenerator.IdFormatter;
import nablarch.core.util.StringUtil;
import nablarch.core.util.annotation.Published;

/**
 * 桁数をフォーマットするクラス。<br>
 * コンストラクタで指定された桁数になるように、指定された文字を先頭に付加する。
 *
 * @author Hisaaki Sioiri
 */
@Published(tag = "architect")
public class LpadFormatter implements IdFormatter {

    /** 桁数 */
    private int length;

    /** 文字 */
    private char c;

    /** コンストラクタ。 */
    public LpadFormatter() {
    }

    /**
     * コンストラクタ。
     *
     * @param length 桁数
     * @param c 指定文字
     */
    public LpadFormatter(int length, char c) {
        this.length = length;
        this.c = c;
    }

    /**
     * コンストラクタで指定された桁数になるように、指定された文字を先頭に付加する。<br>
     * フォーマット対象の値が、指定された桁数より大きい場合はフォーマットをせずに返却する。
     *
     * @param id 採番対象を識別するID
     * @param no フォーマット対象の値
     * @return フォーマット後の値
     * @see nablarch.core.util.StringUtil#lpad(String, int, char)
     */
    @Override
    public String format(String id, String no) {
        return StringUtil.lpad(no, length, c);
    }

    /**
     * 桁数を設定する。
     *
     * @param length 桁数
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * {@link #setLength(int)}で設定した桁数になるまで、埋める文字を設定する。
     *
     * @param paddingChar 埋める文字
     */
    public void setPaddingChar(String paddingChar) {
        if (paddingChar.length() != 1) {
            throw new IllegalArgumentException(
                    "invalid paddingChar length. must be length eq 1.");
        }
        c = paddingChar.charAt(0);
    }
}

