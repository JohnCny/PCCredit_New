package com.cardpay.basic.common.constant;

/**
 * 枚举类型
 * @author yanweichen
 */
public class ConstantEnum {
    /**
     * 用户证件类型
     */
    public enum CertificateType{
        CRET(0,"身份证"),
        PASSPORT(1,"护照"),
        DRIVE(2,"驾驶证");
        private Integer _val;
        private  String _name;
        CertificateType(Integer val,String name){
           this._val = val;
           _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }

        /**
         * 文化程度(8 博士 7  硕士 6 本科  5  大专  4 高中 3  中专 2 初中 1 小学 0 文盲)
         */
        public enum EducationDegree{
            DEGREE0(0, "文盲"),
            DEGREE1(1, "小学"),
            DEGREE2(2, "初中"),
            DEGREE3(3, "中专"),
            DEGREE4(4, "高中"),
            DEGREE5(5, "大专"),
            DEGREE6(6, "本科"),
            DEGREE7(7, "硕士"),
            DEGREE8(8, "博士");

        private Integer _val;
        private  String _name;
        EducationDegree(Integer val,String name){
            this._val = val;
            _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }

    /**
     * 婚姻状况(0 未婚 1  已婚 2  离异  3 未知)
     */
    public enum MarriageStatus{
        STATUS0(0, "未婚"),
        STATUS1(1, "已婚"),
        STATUS2(2, "离异"),
        STATUS3(3, "未知");

        private Integer _val;
        private  String _name;
        MarriageStatus(Integer val,String name){
            this._val = val;
            _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }

    /**
     * 客户状态(0正常，1 高风险用户  2 黑名单用户  3 高风险转黑名单审核  4 黑名单转出  5 禁用客户  6 客户移交中)
     */
    public enum CustomerStatus{
        /**
         * 正常
         */
        STATUS0(0, "正常"),
        /**
         * 高风险用户
         */
        STATUS1(1, "高风险用户"),
        /**
         * 黑名单用户
         */
        STATUS2(2, "黑名单用户"),
        /**
         * 高风险转黑名单审核
         */
        STATUS3(3, "高风险转黑名单审核"),
        /**
         * 黑名单转出
         */
        STATUS4(4, "黑名单转出"),
        /**
         * 禁用客户
         */
        STATUS5(5, "禁用客户"),
        /**
         * 客户移交中
         */
        STATUS6(6, "客户移交中");

        private Integer _val;
        private  String _name;
        CustomerStatus(Integer val,String name){
            this._val = val;
            _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }

    /**
     * 维护类型(0 电话联系 1 上门拜访 2 其他渠道)
     */
    public enum MaintenanceType{
        TYPE0(0, "电话联系"),
        TYPE1(1, "上门拜访"),
        TYPE2(2, "其他渠道");

        private Integer _val;
        private  String _name;
        MaintenanceType(Integer val,String name){
            this._val = val;
            _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }

    /**
     * 意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     */
    public enum TransferStatus{
        STATUS0(0, "带接收人确认"),
        STATUS1(1, "接收人确认"),
        STATUS2(2, "接收人拒绝");

        private Integer _val;
        private  String _name;
        TransferStatus(Integer val,String name){
            this._val = val;
            _name = name;
        }

        public Integer getVal(){
            return this._val;
        }

        public String getName(){
            return this._name;
        }
    }
}
