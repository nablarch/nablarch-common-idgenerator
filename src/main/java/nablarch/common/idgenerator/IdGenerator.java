package nablarch.common.idgenerator;

import nablarch.core.util.annotation.Published;

/**
 * IDを採番するインタフェース。
 *
 * @author Hisaaki Sioiri
 */
@Published(tag = "architect")
public interface IdGenerator {

    /**
     * 引数で指定された採番対象ID内でユニークなIDを採番する。
     *
     * @param id 採番対象を識別するID
     * @return 採番対象ID内でユニークな採番結果のID
     */
    String generateId(String id);

    /**
     * 引数で指定された採番対象ID内でユニークなIDを採番し、指定された{@link nablarch.common.idgenerator.IdFormatter}でフォーマットし返却する。
     *
     * @param id 採番対象を識別するID
     * @param formatter 採番したIDをフォーマットするIdFormatter
     * @return 採番対象ID内でユニークな採番結果のID
     */
    String generateId(String id, IdFormatter formatter);

}
