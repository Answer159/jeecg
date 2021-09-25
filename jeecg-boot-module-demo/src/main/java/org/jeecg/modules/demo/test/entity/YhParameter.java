package org.jeecg.modules.demo.test.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: yh_parameter
 * @Author: jeecg-boot
 * @Date:   2021-09-05
 * @Version: V1.0
 */
@Data
@TableName("yh_parameter")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yh_parameter对象", description="yh_parameter")
public class YhParameter implements Serializable {
    private static final long serialVersionUID = 1L;

	/**parameterId*/
	@Excel(name = "parameterId", width = 15)
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "parameterId")
    private java.lang.Integer parameterId;
	/**parameterName*/
	@Excel(name = "parameterName", width = 15)
    @ApiModelProperty(value = "parameterName")
    private java.lang.String parameterName;
	/**parameterValue*/
	@Excel(name = "parameterValue", width = 15)
    @ApiModelProperty(value = "parameterValue")
    private java.math.BigDecimal parameterValue;
}
