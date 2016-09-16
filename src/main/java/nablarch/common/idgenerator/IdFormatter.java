package nablarch.common.idgenerator;

import nablarch.core.util.annotation.Published;

/**
 * 採番したIDをフォーマットするインタフェース。
 *
 * @author Hisaaki Sioiri
 */
@Published(tag = "architect")
public interface IdFormatter {


    /**
     * 値をフォーマットする。
     *
     * @param id 採番対象を識別するID
     * @param no フォーマット対象の値
     * @return フォーマット後の値
     */
    String format(String id, String no);
}
