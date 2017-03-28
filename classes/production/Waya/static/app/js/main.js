$(function() {
  $('a[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }
  });

  $('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
  });

  $('body').scrollspy({
    target: '.navbar-fixed-top',
    offset: 100
  });

  $('#mainNav').affix({
    offset: {
      top: 50
    }
  });

});