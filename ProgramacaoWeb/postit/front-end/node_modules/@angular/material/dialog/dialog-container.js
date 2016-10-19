var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component, ViewChild, ViewEncapsulation } from '@angular/core';
import { BasePortalHost, PortalHostDirective } from '../core';
import { MdDialogContentAlreadyAttachedError } from './dialog-errors';
/**
 * Internal component that wraps user-provided dialog content.
 */
export var MdDialogContainer = (function (_super) {
    __extends(MdDialogContainer, _super);
    function MdDialogContainer() {
        _super.apply(this, arguments);
    }
    /** Attach a portal as content to this dialog container. */
    MdDialogContainer.prototype.attachComponentPortal = function (portal) {
        if (this._portalHost.hasAttached()) {
            throw new MdDialogContentAlreadyAttachedError();
        }
        return this._portalHost.attachComponentPortal(portal);
    };
    MdDialogContainer.prototype.attachTemplatePortal = function (portal) {
        throw Error('Not yet implemented');
    };
    __decorate([
        ViewChild(PortalHostDirective), 
        __metadata('design:type', PortalHostDirective)
    ], MdDialogContainer.prototype, "_portalHost", void 0);
    MdDialogContainer = __decorate([
        Component({selector: 'md-dialog-container',
            template: "<template portalHost></template> ",
            styles: ["md-dialog-container { box-shadow: 0px 11px 15px -7px rgba(0, 0, 0, 0.2), 0px 24px 38px 3px rgba(0, 0, 0, 0.14), 0px 9px 46px 8px rgba(0, 0, 0, 0.12); display: block; overflow: hidden; padding: 24px; } /*# sourceMappingURL=dialog-container.css.map */ "],
            host: {
                'class': 'md-dialog-container',
                '[attr.role]': 'dialogConfig?.role'
            },
            encapsulation: ViewEncapsulation.None,
        }), 
        __metadata('design:paramtypes', [])
    ], MdDialogContainer);
    return MdDialogContainer;
}(BasePortalHost));

//# sourceMappingURL=dialog-container.js.map
