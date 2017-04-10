# AndroidLView
##  5.0新增控件：
	NavigationView		导航，被设计用于应用导航，提供了一种通用的导航方式；
	Toolbar			代替ActionBar
	TabLayout		与ViewPager合用
	FloatingActionButton	继承于ImagButton，和button的用法几乎一样，可以通过app:layout_anchorGravity属性设置它浮动的位置，通过app:layout_anchor属性设置浮动在哪个View上面。
	Snackbar		用法类似于Toast，一种底部弹出式的新消息提醒机制。
	CardView		提供了一种类似于卡片风格的布局样式，可以自定义圆角度数和阴影面积等，继承于FrameLayout。
	RecyclerView		替代ListView，功能更强大。
	TextInputLayout		一般嵌套一个EditText，用来在输入内容后提示内容显示在外面，还具有空校验。
	CoordinatorLayout	该控件和新发布的这些控件联合使用，只要把他作为一个容器类使用就好了，一边用作跟布局。
	AppBarLayout		用来和toolbar联合使用，达到Material Design效果。
	CollapsingToolbarLayout 提供了一个可以折叠的Toolbar，它继承至FrameLayout，给它设置layout_scrollFlags，它可以控制包含在CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)在响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)。
	Palette			从一张图片中提取出关键的颜色，可以把该颜色值设置到别的控件上面。
	RippleDrawable		点击波纹背景
