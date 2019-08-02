<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/wechat_lib.jsp"%>

<!-- key word star -->
	<div class="key-word show" id="key-word-addr">
		<div class="midder-wrapper">
			<div class="closed-box">
				<span id="key-word-addr-closed">关闭</span>
			</div>
			<div class="key-body">
				<div class="key-box">
					<div class="key-item">京</div>
					<div class="key-item">津</div>
					<div class="key-item">沪</div>
					<div class="key-item">渝</div>
					<div class="key-item">冀</div>
					<div class="key-item">豫</div>
					<div class="key-item">云</div>
					<div class="key-item">辽</div>
					<div class="key-item">黑</div>
					<div class="key-item">湘</div>
				</div>
				<div class="key-box key-box-90">
					<div class="key-item">皖</div>
					<div class="key-item">鲁</div>
					<div class="key-item">新</div>
					<div class="key-item">苏</div>
					<div class="key-item">浙</div>
					<div class="key-item">赣</div>
					<div class="key-item">鄂</div>
					<div class="key-item">桂</div>
					<div class="key-item">甘</div>
				</div>
				<div class="key-box key-box-80">
					<div class="key-item">晋</div>
					<div class="key-item">蒙</div>
					<div class="key-item">陕</div>
					<div class="key-item">吉</div>
					<div class="key-item">闽</div>
					<div class="key-item">贵</div>
					<div class="key-item">粤</div>
					<div class="key-item">青</div>
				</div>
				<div class="key-box key-box-60">
					<div class="key-item">藏</div>
					<div class="key-item">川</div>
					<div class="key-item">宁</div>
					<div class="key-item">琼</div>
					<div class="key-item">使</div>
					<div class="key-item">无</div>
				</div>
			</div>
		</div>
	</div>
	<div class="key-word" id="key-word-num">
		<div class="midder-wrapper">
			<div class="closed-box">
				<span id="key-word-num-closed">关闭</span>
			</div>
			<div class="key-body">
				<div class="del" id="del">←</div>
				<div class="key-box">
					<div class="key-item">1</div>
					<div class="key-item">2</div>
					<div class="key-item">3</div>
					<div class="key-item">4</div>
					<div class="key-item">5</div>
					<div class="key-item">6</div>
					<div class="key-item">7</div>
					<div class="key-item">8</div>
					<div class="key-item">9</div>
					<div class="key-item">0</div>
				</div>
				<div class="key-box">
					<div class="key-item">Q</div>
					<div class="key-item">W</div>
					<div class="key-item">E</div>
					<div class="key-item">R</div>
					<div class="key-item">T</div>
					<div class="key-item">Y</div>
					<div class="key-item">U</div>
					<div class="key-item">I</div>
					<div class="key-item">O</div>
					<div class="key-item">P</div>
					<div class="key-item">港</div>
				</div>
				<div class="key-box">
					<div class="key-item">A</div>
					<div class="key-item">S</div>
					<div class="key-item">D</div>
					<div class="key-item">F</div>
					<div class="key-item">G</div>
					<div class="key-item">H</div>
					<div class="key-item">J</div>
					<div class="key-item">K</div>
					<div class="key-item">L</div>
					<div class="key-item">警</div>
				</div>
				<div class="key-box key-box-70">
					<div class="key-item">Z</div>
					<div class="key-item">X</div>
					<div class="key-item">C</div>
					<div class="key-item">V</div>
					<div class="key-item">B</div>
					<div class="key-item">N</div>
					<div class="key-item">M</div>
				</div>
			</div>
		</div>
	</div>
	<!-- key word end -->
	
	
<!--js star-->

<script type="text/javascript" charset="utf-8">
	// mui.init();
	$(function($) {
		// 车牌框点击
		var lastIndex = '';
		$('#car-num-wrapper .car-box').each(function(){
			$(this).click(function() {
				var index = $(this).index();
				$(this).siblings().removeClass('active')
				$(this).addClass('active');
				if (index > 0) {
					// 判断上一个键盘有没有显示
					if ($('#key-word-addr').hasClass('show')) {
						$('#key-word-addr').removeClass('show');
					}
					// 点击是同一个框
					if (index === lastIndex) {
						if ($('#key-word-num').hasClass('show')) {
							$('#key-word-num').removeClass('show');
							$(this).removeClass('active');
						} else {
							$('#key-word-num').addClass('show');
							$(this).addClass('active');
						}
					} else {
						$('#key-word-num').removeClass('show');
						$('#key-word-num').addClass('show');
					}
					
				} else {
					if ($('#key-word-num').hasClass('show')) {
						$('#key-word-num').removeClass('show');
					}
					if ($('#key-word-addr').hasClass('show')) {
						$('#key-word-addr').removeClass('show');
						$(this).removeClass('active');
					} else {
						$('#key-word-addr').addClass('show');
						$(this).addClass('active');
					}
				}
				lastIndex = index;
			})
		})

		// 键盘1点击
		$("#key-word-addr .key-item").each(function() {
			$(this).click(function() {
				var text = $(this).html();
				$('#car-num-wrapper .car-box').eq(0).html(text);
				$('#car-num-wrapper .car-box').eq(0).removeClass('active');
				$('#car-num-wrapper .car-box').eq(1).addClass('active');
				$("#key-word-addr").removeClass('show');
				$("#key-word-num").addClass('show');
				
				var nums=0;
				$(".car-box").each(function(){
					if($(this).html() != ''){
					nums=nums+1;
					}
				});
				if(nums>=7){
					$("#btShow").show();
					$("#btHide").hide();
				}else{
					$("#btShow").hide();
					$("#btHide").show();
				}
			})
		})

		// 键盘2点击
		$("#key-word-num .key-item").each(function() {
			$(this).click(function() {
				var text = $(this).html();
				var _index;
				$('#car-num-wrapper .car-box').each(function(){
					if ($(this).hasClass('active')) {
						$(this).html(text)
						_index = $(this).index();
						$(this).removeClass('active');
					}
				})
				$('#car-num-wrapper .car-box').eq(_index + 1).addClass('active');
				if (_index + 1 >= $('#car-num-wrapper .car-box').length) {
					$("#key-word-num").removeClass('show');
				}
				
				var nums=0;
				$(".car-box").each(function(){
					if($(this).html() != ''){
					nums=nums+1;
					}
				});
				
				
				//if(nums>=3){
					//checkCardNo();
				//}
				
				if(nums>=7){
					$("#btShow").show();
					$("#btHide").hide();
				}else{
					$("#btShow").hide();
					$("#btHide").show();
				}
				
				
			})
		})
		// 关闭
		$("#key-word-num-closed").click(function() {
			$("#key-word-num").removeClass('show');
			$('#car-num-wrapper .car-box').removeClass('active');
		})
		$("#key-word-addr-closed").click(function() {
			$("#key-word-addr").removeClass('show');
			$('#car-num-wrapper .car-box').removeClass('active');
		})
		// 删除
		$("#del").click(function(){
			$('#car-num-wrapper .car-box').each(function(){
				var _index;
				if ($(this).hasClass('active')) {
					_index = $(this).index();
					$(this).html('');
					$(this).removeClass('active');
				}
				$('#car-num-wrapper .car-box').eq(_index - 1).addClass('active');
				if (_index === 1) {
					$("#key-word-num").removeClass('show');
					$("#key-word-addr").addClass('show');
				}
			})
			
			var nums=0;
				$(".car-box").each(function(){
					if($(this).html() != ''){
					nums=nums+1;
					}
				});
				
				if(nums>=7){
					$("#btShow").show();
					$("#btHide").hide();
				}else{
					$("#btShow").hide();
					$("#btHide").show();
				}
			
		})

		
	});
</script>
<!--js end-->
