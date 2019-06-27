/********************************************
 * 文件名称: RpcService.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/26 14:28
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author an.lv
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RpcService {
    Class<?> value();

    String name();
}
