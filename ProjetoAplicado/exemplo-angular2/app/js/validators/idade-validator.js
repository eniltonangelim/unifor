System.register([], function(exports_1) {
    var IdadeValidator;
    return {
        setters:[],
        execute: function() {
            IdadeValidator = (function () {
                function IdadeValidator() {
                }
                IdadeValidator.validate = function (control) {
                    if (IdadeValidator.IDADE_REGEX.test(control.value)) {
                        return null;
                    }
                    return { 'idade': true };
                };
                IdadeValidator.IDADE_REGEX = /^[0-9]{1,3}$/;
                return IdadeValidator;
            })();
            exports_1("IdadeValidator", IdadeValidator);
        }
    }
});
//# sourceMappingURL=idade-validator.js.map