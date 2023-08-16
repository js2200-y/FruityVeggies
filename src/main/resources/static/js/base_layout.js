/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {
/*스크롤 컨트롤*/    
    const lnb = document.querySelector("#lnb");
    const lnbOffsetTop = lnb.offsetTop;
    
    const nevi = document.querySelector("div.text-end");

    window.addEventListener('scroll', function() {
    const scrollTop = window.scrollY || document.documentElement.scrollTop;

    if (lnbOffsetTop <= scrollTop) {
        // 스크롤 함
      lnb.classList.add('fixed');
      document.getElementById('text-end1').style.display = 'block';
      document.getElementById('text-end2').style.display = 'block';
      
      
    } else {
        // 스크롤 안함
      lnb.classList.remove('fixed');
      document.getElementById('text-end1').style.display = 'none';
      document.getElementById('text-end2').style.display = 'none';
    }
  });
/*스크롤 컨트롤*/    
    
    const loginBtn = document.querySelector('button#loginBtn1');
    loginBtn.addEventListener('click', function(){
        console.log('login');
        location.href="/login";
    });
    
    
    const signBtn = document.querySelector('button#signBtn1');
    signBtn.addEventListener('click', function(){
        console.log('signup');
    });
    const loginBtn1 = document.querySelector('button#loginBtn1');
    loginBtn1.addEventListener('click', function(){
        console.log('login1');
        location.href="/login";
    });
    
    
    const signBtn1 = document.querySelector('button#signBtn1');
    signBtn1.addEventListener('click', function(){
        console.log('signup1');
    });
});

/*$(function() {
        var lnb = $("#lnb").offset().top;
        $(window).scroll(function() {
          var window = $(this).scrollTop();

          if(lnb <= window) {
            $("#lnb").addClass("fixed");
          } else {
            $("#lnb").removeClass("fixed");
          }
        })
      });*/