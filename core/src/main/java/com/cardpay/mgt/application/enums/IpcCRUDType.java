package com.cardpay.mgt.application.enums;

/**
 * IPC增删改查类型
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/6 14:53
 */
public enum IpcCRUDType {

    NORMAL_VAR("一般模板var",1),
    NORMAL_EXT("一般模板额外值",2),
    CASHFLOW_PROFIT_VAR("现金流类型模板var",3),
    CASHFLOW_PROFIT_EXT("现金流类型模板额外值",4);

    private String typeName;
    private Integer type;

    IpcCRUDType(String typeName, Integer type) {
        this.typeName = typeName;
        this.type = type;
    }

    public String gettypeName() {
        return typeName;
    }

    public void settypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer gettype() {
        return type;
    }

    public void settype(Integer type) {
        this.type = type;
    }

    public static IpcCRUDType getIpcCRUDTypeById(Integer ipcCRUDType){
        switch (ipcCRUDType){
            case 1:
                return NORMAL_VAR;
            case 2:
                return NORMAL_EXT;
            case 3:
                return CASHFLOW_PROFIT_VAR;
            case 4:
                return CASHFLOW_PROFIT_EXT;
            default:
                break;
        }
        throw new IllegalArgumentException("未找到对应IpcCRUD类型");
    }
}
