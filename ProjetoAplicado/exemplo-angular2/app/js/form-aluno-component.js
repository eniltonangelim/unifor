System.register(['angular2/core', './model/curso', './model/aluno'], function(exports_1) {
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, curso_1, aluno_1;
    var FormAlunoComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (curso_1_1) {
                curso_1 = curso_1_1;
            },
            function (aluno_1_1) {
                aluno_1 = aluno_1_1;
            }],
        execute: function() {
            FormAlunoComponent = (function () {
                function FormAlunoComponent() {
                    this.sucesso = false;
                    this.aluno = new aluno_1.Aluno();
                    this.cursos = [
                        new curso_1.Curso('angular2', 'Angular 2'),
                        new curso_1.Curso('javaee', 'Java EE')
                    ];
                }
                FormAlunoComponent.prototype.debug = function () {
                    return JSON.stringify("Dados do aluno");
                };
                FormAlunoComponent = __decorate([
                    core_1.Component({
                        selector: 'form-aluno',
                        templateUrl: 'app/view/form-aluno.html'
                    }), 
                    __metadata('design:paramtypes', [])
                ], FormAlunoComponent);
                return FormAlunoComponent;
            })();
            exports_1("FormAlunoComponent", FormAlunoComponent);
        }
    }
});
//# sourceMappingURL=form-aluno-component.js.map