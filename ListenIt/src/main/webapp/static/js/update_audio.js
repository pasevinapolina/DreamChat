$('.aud-upd').click(function () {
    var id = $(this).parent().children('#plId').text();

    $('#nameUpd').val($(this).parent().children('#plName').text());
    $('#singerUpd').val($(this).parent().children('#plSinger').text());
    $('#descrUpd').val($(this).parent().children('#plDescr').text());
    $('#audFileSrc').attr("src", $(this).parent().children('#plSrc').text());

    var iu = '/myAudios/' + id + '/update';
    $('#updateAudForm').attr('action', iu);
});