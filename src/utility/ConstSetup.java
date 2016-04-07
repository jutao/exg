package utility;




public class ConstSetup {
	
	
	
	
	//数据库所有者
	public static String DATABASE_OWNER="";
	
	//数据库类型
	public static String DATABASE="MYSQL";
	
	//分页行数
	public static String REFERENCE_RANGE="10";
	
	//显示列截流
	public static Integer SPLIT_COLUMN_LENGTH=Utilities.csi.getInteger(0);
	
	//项目的物理路径
	public static String PHYSICAL_PATH="";
	
	//临时文件夹
	public static String TMP_FILE="";
	
	//图片验证session常量
	public static String SESSION_VERIFY_PIC="verifyPic";
	
	//验证图片大小
	public static int VERIFY_PIC_SIZE_WIDTH=100;
	public static int VERIFY_PIC_SIZE_HEIGHT=100;
	
	//图片验证填充色RGB
	public static int VERIFY_PIC_BACKGROUND_R=0;
	public static int VERIFY_PIC_BACKGROUND_G=0;
	public static int VERIFY_PIC_BACKGROUND_B=0;
	
	//图片验证笔刷颜色RGB
	public static int VERIFY_PIC_BRUSH_R=0;
	public static int VERIFY_PIC_BRUSH_G=0;
	public static int VERIFY_PIC_BRUSH_B=0;
	
	//验证图片字体
	public static String VERIFY_PIC_FONT="Times New Roman Bold";
	
	//验证图片字体大小
	public static int VERIFY_PIC_FONT_SIZE=28;
	
	//验证图片随机字母
	public static String VERIFY_PIC_RANDOM_ALPHA="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	//验证图片字符长度
	public static int VERIFY_PIC_LENGTH=5;
	
	//自定义纸张大小判断
	public static boolean CUSTOM_PAPER_SIZE=false;
	
	//常规纸张大小
	public static String PAPER_SIZE="A4";
	
	//自定义纸张宽度
	public static int WIDTH_SIZE=210;
	
	//自定义纸张高度
	public static int HEIGHT_SIZE=297;
	
	//横向打印
	public static boolean ROTATE=false;
	
	//左边距
	public static int LEFT_MARGIN=10;
	
	//右边距
	public static int RIGHT_MARGIN=10;
	
	//上边距
	public static int TOP_MARGIN=10;
	
	//下边距
	public static int BOTTOM_MARGIN=10;
	
	//章节字体大小
	public static int CHAPTER_FONT_SIZE=18;
	
	//章节文字颜色
	public static int CHAPTER_FONT_COLOR_R=0;
	public static int CHAPTER_FONT_COLOR_G=0;
	public static int CHAPTER_FONT_COLOR_B=0;
	
	//表格颜色
	public static int TABLE_COLOR_R=0;
	public static int TABLE_COLOR_G=0;
	public static int TABLE_COLOR_B=0;
	
	//表格填料大小
	public static int PADDING=2;
	
	//表格单元格间隔大小
	public static int SPACING=0;
	
	//表格边框宽度
	public static int BORDER_WIDTH=1;
	
	//表格字体大小
	public static int TABLE_FONT_SIZE=12;
	
	//表格字体颜色
	public static int TABLE_FONT_COLOR_R=0;
	public static int TABLE_FONT_COLOR_G=0;
	public static int TABLE_FONT_COLOR_B=0;
	
	//邮件设置
	public static String SMTP="";
	public static String VALIDATE="";
	public static String USERNAME="";
	public static String PASSWORD="";
	public static String SENDER="";
	
	
	public static String TOP_CAROUSEL_CATEGORY="5";//广告（图片轮播）
	
	public static String ENTER_SYMBOL=Utilities.getEnterSymbol();//回车符
	
	public static String CHECKSTATUS_CATEGORY="checkstatus";//登录
	public static String REGIST_CATEGORY="regist";//注册
	public static String LOGIN_CATEGORY="login";//登录
	public static String LOGOUT_CATEGORY="logout";//退出登录
	public static String PURCHASE_CATEGORY="purchase";//购买
	public static String PAYMENT_CATEGORY="payment";//购买
	public static String SETUP_CATEGORY="setup";//购买
	public static String REDBAG_CATEGORY="redbag";//红包 
	public static String INVITE_CATEGORY="invite";//邀请
	public static String SETUP_TP_CATEGORY="setup_trading_passwd";//设置交易密码
	public static String MODIFY_TP_CATEGORY="modify_trading_passwd";//修改交易密码
	public static String FORGET_TP_CATEGORY="forget_trading_passwd"; //忘记交易密码
	public static String FORGET_LP_CATEGORY="forget_login_passwd"; //忘记登录密码
	public static String FORGET_GP_CATEGORY="forget_gesture_passwd"; //忘记手势密码
	public static String MODIFY_LP_CATEGORY="modify_login_passwd"; //修改登录密码
	public static String MODIFY_GP_CATEGORY="modify_gesture_passwd";//修改手势密码
	public static String MODIFY_P_CATEGORY="modify_phone";//修改手机
	public static String MODIFY_CN_CATEGORY="modify_card_number";//修改银行卡
	
//	public static String PINGPP_APIKEY = "sk_test_0OOar1TeHqr9SqPGWDPC0eTG";   // Ping++ Test Secret Key
	public static String PINGPP_APIKEY = "sk_live_Tefjf1iDeXvL4qLW14TWLWTC";   // Ping++ Live Secret Key 
	public static String PINGPP_APPID = "app_ej98eTfj9m1OPGaD";   // Ping++ 应用 ID (App_ID)
}