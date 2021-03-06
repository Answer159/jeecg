package org.jeecg.modules.demo.test.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.test.entity.YhHealthCert;
import org.jeecg.modules.demo.test.service.IYhHealthCertService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: yh_health_cert
 * @Author: jeecg-boot
 * @Date:   2021-09-25
 * @Version: V1.0
 */
@Api(tags="yh_health_cert")
@RestController
@RequestMapping("/test/yhHealthCert")
@Slf4j
public class YhHealthCertController extends JeecgController<YhHealthCert, IYhHealthCertService> {
	@Autowired
	private IYhHealthCertService yhHealthCertService;

	/**
	 * ??????????????????
	 *
	 * @param yhHealthCert
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-??????????????????")
	@ApiOperation(value="yh_health_cert-??????????????????", notes="yh_health_cert-??????????????????")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(YhHealthCert yhHealthCert,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<YhHealthCert> queryWrapper = QueryGenerator.initQueryWrapper(yhHealthCert, req.getParameterMap());
		Page<YhHealthCert> page = new Page<YhHealthCert>(pageNo, pageSize);
		IPage<YhHealthCert> pageList = yhHealthCertService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   ??????
	 *
	 * @param yhHealthCert
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-??????")
	@ApiOperation(value="yh_health_cert-??????", notes="yh_health_cert-??????")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody YhHealthCert yhHealthCert) {
		LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
		yhHealthCert.setUploadUserId(sysUser.getId());
		Date current_date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(yhHealthCert.getIssueDate());
		cal.add(Calendar.YEAR, 2);
		long t=cal.getTimeInMillis();
		Date date=new Date(t);
		yhHealthCert.setValidity(date);
		yhHealthCert.setUploadDate(current_date);
		yhHealthCertService.save(yhHealthCert);
		return Result.OK("???????????????");

	}

	/**
	 *  ??????
	 *
	 * @param yhHealthCert
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-??????")
	@ApiOperation(value="yh_health_cert-??????", notes="yh_health_cert-??????")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody YhHealthCert yhHealthCert) {
		Date current_date = new Date();
		yhHealthCert.setUploadDate(current_date);
		yhHealthCertService.updateById(yhHealthCert);
		return Result.OK("????????????!");

	}

	/**
	 *   ??????id??????
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-??????id??????")
	@ApiOperation(value="yh_health_cert-??????id??????", notes="yh_health_cert-??????id??????")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		yhHealthCertService.removeById(id);
		return Result.OK("????????????!");
	}

	/**
	 *  ????????????
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-????????????")
	@ApiOperation(value="yh_health_cert-????????????", notes="yh_health_cert-????????????")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.yhHealthCertService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("??????????????????!");
	}

	/**
	 * ??????id??????
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "yh_health_cert-??????id??????")
	@ApiOperation(value="yh_health_cert-??????id??????", notes="yh_health_cert-??????id??????")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		YhHealthCert yhHealthCert = yhHealthCertService.getById(id);
		if(yhHealthCert==null) {
			return Result.error("?????????????????????");
		}
		return Result.OK(yhHealthCert);
	}

    /**
    * ??????excel
    *
    * @param request
    * @param yhHealthCert
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, YhHealthCert yhHealthCert) {
        return super.exportXls(request, yhHealthCert, YhHealthCert.class, "yh_health_cert");
    }

    /**
      * ??????excel????????????
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, YhHealthCert.class);
    }

}
