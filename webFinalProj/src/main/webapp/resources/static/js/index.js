// // main
// var leftmouse = 0;

// $('.article-before').on('click', function () {
//     leftmouse++;

//     if (leftmouse % 2 != 0) {
//         processA($(this).index());
//     } else {
//         processB($(this).index());
//     }
// })

// function processA(idx) {
//     let elem = $('.article-before');

//     for (let i = 0; i < elem.length; i++) {
//         if (i == idx) {
//             continue;
//         }
//         $(elem[i]).hide();
//     }

//     $('#after-' + (idx + 1)).animate({
//         width: 'toggle'
//     });

//     let color = '';

//     if (idx == 0) {
//         color = 'red';
//     } else if (idx == 1) {
//         color = 'orange';
//     } else if (idx == 2) {
//         color = 'yellow';
//     } else if (idx == 3) {
//         color = 'green';
//     }

//     $('#after-' + (idx + 1)).css('background', color);
//     $('#before-' + (idx + 1)).css('width', '20%');
//     $('.article-before p').hide();
//     $('.article-before .img').css('margin-top', '12.5vh');
// }

// function processB(idx) {
//     let elem = $('.article-before');

//     for (let i = 0; i < elem.length; i++) {
//         if (i == idx) {
//             continue;
//         }
//         $(elem[i]).show();
//     }

//     $('.article-after').hide();
//     $('#before-' + (idx + 1)).css('width', '25%');
//     $('p').show();
//     $('.article-before .img').css('margin-top', '5vh');
// }

// // gallery
// let now = 1;

// $('.right').on('click', function () {
//     galleryGroup(1);
// })

// $('.left').click(() => {
//     galleryGroup(-1);
// })

// function galleryGroup(cnt) {
//     now += cnt;
//     if (now > 3) {
//         now = 3;
//     } else if (now < 1) {
//         now = 1;
//     } else {
//         $('.gallery-group').attr('class', 'gallery-group slide-' + now);
//     }
// }