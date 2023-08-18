function showContent(sectionId) {
    var sections = document.querySelectorAll('.section-content'); // 모든 섹션 요소 선택

    // 모든 섹션 요소의 클래스 제거
    sections.forEach(function(section) {
        section.classList.remove('active');
    });

    // 선택한 섹션 요소의 클래스 추가
    var selectedSection = document.getElementById(sectionId);
    if (selectedSection) {
        selectedSection.classList.add('active');
      
      // 부드러운 스크롤 애니메이션
      window.scrollTo({
        top: selectedSection.offsetTop,
        behavior: 'smooth'
      });
    }
}

document.addEventListener('DOMContentLoaded', function() {
    var sectionLinks = document.querySelectorAll('.section-link');

    sectionLinks.forEach(function(link) {
        link.addEventListener('click', function(event) {
            event.preventDefault(); // 기본 동작 중지
            var sectionId = link.getAttribute('data-section-id');
            showContent(sectionId);
        });
    });
});
