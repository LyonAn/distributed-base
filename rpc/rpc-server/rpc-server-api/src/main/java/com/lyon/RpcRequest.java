/********************************************
 * 文件名称: RpcRequest.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/25 23:02
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import java.io.Serializable;

/**
 * @author an.lv
 */
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
