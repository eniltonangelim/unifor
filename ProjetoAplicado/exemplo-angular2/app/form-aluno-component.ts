import {Component} from 'angular2/core';
import {Curso} from './model/curso';
import {Aluno} from './model/aluno';

@Component({
    selector: 'form-aluno',
    templateUrl: 'app/view/form-aluno.html'
})
export class FormAlunoComponent{
    cursos: Curso[];
    aluno: Aluno;     

    sucesso: boolean = false;
    constructor() {
          this.aluno = new Aluno();
          this.cursos = [
               new Curso('angular2', 'Angular 2'),
               new Curso('javaee', 'Java EE')
          ];    
    }
    
    debug(): string {
        return JSON.stringify("Dados do aluno");
    }

}

