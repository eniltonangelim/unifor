import {Control} from 'angular2/common';
export class IdadeValidator {

    private static IDADE_REGEX = /^[0-9]{1,3}$/;

    static validate(control: Control): {[key: string]: boolean} {
        if (IdadeValidator.IDADE_REGEX.test(control.value)) {
            return null;
        }
        return { 'idade': true };
    }
}
