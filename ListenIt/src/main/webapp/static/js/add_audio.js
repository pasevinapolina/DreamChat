$.validator.addMethod('filesize', function(value, element, param) {
    // param = size (en bytes)
    // element = element to validate (<input>)
    // value = value of the element (file name)
    return this.optional(element) || (element.files[0].size <= param)
});

$('#addAudioForm').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
        audioName: {
            required: true,
            minlength: 5,
            maxlength: 30
        },
        audioDescription: {
            minlength: 10,
            required: true
        },
        singer: {
            minlength: 1,
            required: true
        },
        audFile: {
            required: true,
            extension: 'mp3|ogg|wav|mpeg',
            filesize: 50 * 1024 * 1024
        }
    }
});

$.validator.messages.filesize = 'File must less 50Mb';