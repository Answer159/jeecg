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
 * @Description: yh_health_cert
 * @Author: jeecg-boot
 * @Date:   2021-09-25
 * @Version: V1.0
 */
@Data
@TableName("yh_health_cert")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="yh_health_cert对象", description="yh_health_cert")
public class YhHealthCert implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**employeeId*/
	@Excel(name = "employeeId", width = 15)
    @ApiModelProperty(value = "employeeId")
    private java.lang.String employeeId;
	/**apartment*/
	@Excel(name = "apartment", width = 15)
    @ApiModelProperty(value = "apartment")
    private java.lang.String apartment;
	/**certNum*/
	@Excel(name = "certNum", width = 15)
    @ApiModelProperty(value = "certNum")
    private java.lang.String certNum;
	/**issuingAuthority*/
	@Excel(name = "issuingAuthority", width = 15)
    @ApiModelProperty(value = "issuingAuthority")
    private java.lang.String issuingAuthority;
	/**validity*/
	@Excel(name = "validity", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "validity")
    private java.util.Date validity;
	/**issueDate*/
	@Excel(name = "issueDate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "issueDate")
    private java.util.Date issueDate;
	/**uploadFileName*/
	@Excel(name = "uploadFileName", width = 15)
    @ApiModelProperty(value = "uploadFileName")
    private java.lang.String uploadFileName;
	/**uploadUserId*/
	@Excel(name = "uploadUserId", width = 15)
    @ApiModelProperty(value = "uploadUserId")
    private java.lang.String uploadUserId;
	/**uploadDate*/
	@Excel(name = "uploadDate", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "uploadDate")
    private java.util.Date uploadDate;
}
