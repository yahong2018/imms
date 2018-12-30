package com.zhxh.core.data.DataCode;

public final class BCode {
    //
    //状态：0~999
    //
    public static final int STATUS_NORMAL = 0;                       //0:正常
    public final static int STATUS_ENABLED = 0;                      //0.启用
    public final static int STATUS_DISABLED = 1;                     //1:停用
    public final static int STATUS_OFFLINE = 0;                      //0.离线
    public final static int STATUS_ONLINE = 1;                       //1.在线

    //
    //C类编码类型
    //
    public final static String CODE_TYPE_C_MATERIAL_TYPE = "MATERIAL_TYPE";
    public final static String CODE_TYPE_C_MACHINE_TYPE = "MACHINE_TYPE";
    public final static String CODE_TYPE_C_DEFECT_TYPE = "DEFECT_TYPE";

    //
    //权限
    //
    public final static String PRIVILEGE_RUN = "RUN";
    public final static String PRIVILEGE_INSERT = "INSERT";
    public final static String PRIVILEGE_UPDATE = "UPDATE";
    public final static String PRIVILEGE_DELETE = "DELETE";

    public final static String PRIVILEGE_ENABLE_USER = "ENABLE_USER";
    public final static String PRIVILEGE_DISABLE_USER = "DISABLE_USER";
    public final static String PRIVILEGE_ASSIGN_ROLE = "ASSIGN_ROLE";
    public final static String PRIVILEGE_RESET_PASSWORD = "RESET_PASSWORD";

    //
    //方向
    //
    public final static int DIRECTION_LEFT = 0;                        //左边
    public final static int DIRECTION_RIGHT = 1;                       //右边

    //
    //旋转方向
    //
    public final static int RATION_CLOCKWISE = 0;                      //顺时针
    public final static int RATION_ANTI_CLOCKWISE = 1;                 //逆时针

    //
    //工位类型
    //
    public final static int WORK_STATION_TYPE_CUT = 0;                 //裁剪工位
    public final static int WORK_STATION_TYPE_STITCH = 1;              //缝制工位
    public final static int WORK_STATION_TYPE_HANG = 2;                //上吊挂工位
    public final static int WORK_STATION_TYPE_QUALITY = 3;             //质检工位
    public final static int WORK_STATION_TYPE_PRINT = 4;               //打印工位

    private BCode() {
    }
}
