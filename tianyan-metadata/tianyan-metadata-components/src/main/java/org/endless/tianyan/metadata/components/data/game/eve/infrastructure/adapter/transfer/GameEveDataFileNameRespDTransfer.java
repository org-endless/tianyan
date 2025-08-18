package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveDataFileNameRespDTransfer
 * <p>游戏EVE数据文件名称被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"de", "en", "es", "fr", "ja", "ru", "zh"})
public class GameEveDataFileNameRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 德文名称
     */
    private final String de;

    /**
     * 英文名称
     */
    private final String en;

    /**
     * 西班牙文名称
     */
    private final String es;

    /**
     * 法文名称
     */
    private final String fr;

    /**
     * 日文名称
     */
    private final String ja;

    /**
     * 俄文名称
     */
    private final String ru;

    /**
     * 中文名称
     */
    private final String zh;

    @Override
    public GameEveDataFileNameRespDTransfer validate() {
        validateDe();
        validateEn();
        validateEs();
        validateFr();
        validateJa();
        validateRu();
        validateZh();
        return this;
    }

    private void validateDe() {
        if (!StringUtils.hasText(de)) {
            throw new DrivenRespTransferValidateException("德文名称不能为空");
        }
    }

    private void validateEn() {
        if (!StringUtils.hasText(en)) {
            throw new DrivenRespTransferValidateException("英文名称不能为空");
        }
    }

    private void validateEs() {
        if (!StringUtils.hasText(es)) {
            throw new DrivenRespTransferValidateException("西班牙文名称不能为空");
        }
    }

    private void validateFr() {
        if (!StringUtils.hasText(fr)) {
            throw new DrivenRespTransferValidateException("法文名称不能为空");
        }
    }

    private void validateJa() {
        if (!StringUtils.hasText(ja)) {
            throw new DrivenRespTransferValidateException("日文名称不能为空");
        }
    }

    private void validateRu() {
        if (!StringUtils.hasText(ru)) {
            throw new DrivenRespTransferValidateException("俄文名称不能为空");
        }
    }

    private void validateZh() {
        if (!StringUtils.hasText(zh)) {
            throw new DrivenRespTransferValidateException("中文名称不能为空");
        }
    }
}
