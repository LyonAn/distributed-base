/********************************************
 * 文件名称: PayServiceImpl.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/26 15:48
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import org.springframework.stereotype.Component;

/**
 * @author an.lv
 */
@RpcService(value = IPayService.class, name = "支付服务接口")
@Component
public class PayServiceImpl implements IPayService {
    @Override
    public String doPay(String content) {
        System.out.println("get Request: 支付 " + content + "元");
        return "支付成功：-" + content +"元";
    }
}
