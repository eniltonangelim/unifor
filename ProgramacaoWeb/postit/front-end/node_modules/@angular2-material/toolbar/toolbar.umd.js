(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? factory(exports, require('@angular/core')) :
    typeof define === 'function' && define.amd ? define(['exports', '@angular/core'], factory) :
    (factory((global.md = global.md || {}, global.md.toolbar = global.md.toolbar || {}),global.ng.core));
}(this, (function (exports,_angular_core) { 'use strict';

var __decorate = (window && window.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (window && window.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var MdToolbarRow = (function () {
    function MdToolbarRow() {
    }
    MdToolbarRow = __decorate([
        _angular_core.Directive({
            selector: 'md-toolbar-row'
        }), 
        __metadata('design:paramtypes', [])
    ], MdToolbarRow);
    return MdToolbarRow;
}());
var MdToolbar = (function () {
    function MdToolbar(elementRef, renderer) {
        this.elementRef = elementRef;
        this.renderer = renderer;
    }
    Object.defineProperty(MdToolbar.prototype, "color", {
        get: function () {
            return this._color;
        },
        set: function (value) {
            this._updateColor(value);
        },
        enumerable: true,
        configurable: true
    });
    MdToolbar.prototype._updateColor = function (newColor) {
        this._setElementColor(this._color, false);
        this._setElementColor(newColor, true);
        this._color = newColor;
    };
    MdToolbar.prototype._setElementColor = function (color, isAdd) {
        if (color != null && color != '') {
            this.renderer.setElementClass(this.elementRef.nativeElement, "md-" + color, isAdd);
        }
    };
    __decorate([
        _angular_core.Input(), 
        __metadata('design:type', String)
    ], MdToolbar.prototype, "color", null);
    MdToolbar = __decorate([
        _angular_core.Component({selector: 'md-toolbar',
            template: "<div class=\"md-toolbar-layout\"> <md-toolbar-row> <ng-content></ng-content> </md-toolbar-row> <ng-content select=\"md-toolbar-row\"></ng-content> </div>",
            styles: ["md-toolbar { display: flex; box-sizing: border-box; width: 100%; min-height: 64px; font-size: 20px; font-weight: 400; font-family: Roboto, \"Helvetica Neue\", sans-serif; padding: 0 16px; flex-direction: column; } md-toolbar md-toolbar-row { display: flex; box-sizing: border-box; width: 100%; height: 64px; flex-direction: row; align-items: center; } /*# sourceMappingURL=toolbar.css.map */ "],
            changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            encapsulation: _angular_core.ViewEncapsulation.None
        }), 
        __metadata('design:paramtypes', [_angular_core.ElementRef, _angular_core.Renderer])
    ], MdToolbar);
    return MdToolbar;
}());
var MdToolbarModule = (function () {
    function MdToolbarModule() {
    }
    MdToolbarModule.forRoot = function () {
        return {
            ngModule: MdToolbarModule,
            providers: []
        };
    };
    MdToolbarModule = __decorate([
        _angular_core.NgModule({
            exports: [MdToolbar, MdToolbarRow],
            declarations: [MdToolbar, MdToolbarRow],
        }), 
        __metadata('design:paramtypes', [])
    ], MdToolbarModule);
    return MdToolbarModule;
}());

exports.MdToolbarRow = MdToolbarRow;
exports.MdToolbar = MdToolbar;
exports.MdToolbarModule = MdToolbarModule;

Object.defineProperty(exports, '__esModule', { value: true });

})));