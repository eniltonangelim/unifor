import {Component, OnInit} from 'angular2/core';
import {ControlGroup, FormBuilder, Validators, AbstractControl} from 'angular2/common';
import {EmailValidator} from './validators/email-validator';
import {Curso} from './model/curso';
import {Aluno} from './model/aluno';
import {AlunoService} from './service/aluno-service';

@Component({
    selector: 'form-aluno',
    templateUrl: 'app/view/form-aluno.html',
    providers: [AlunoService]
})

export class FormAlunoComponent implements OnInit {

    cursos: Curso[];
    sucesso: boolean = false;
    idEditar: number;
    aluno: Aluno;     
    alunoForm: ControlGroup;
    alunos: Aluno[];

    constructor(private fb: FormBuilder, private alunoService: AlunoService) {

    }

    ngOnInit() {
        this.aluno = new Aluno();
        this.cursos = [
            new Curso('angular2', 'Angular 2'),
            new Curso('javaee', 'Java EE')
        ];
        this.buildForm(this.fb);

        this.idEditar = -1;
        this.alunos = this.alunoService.listarTodos();
    }

    constructor(fb: FormBuilder) {
        this.aluno = new Aluno();
        this.cursos = [
           new Curso('angular2', 'Angular 2'),
           new Curso('javaee', 'Java EE')
        ]; 
    	this.buildForm(fb);
    }

    constructor() {
        this.aluno = new Aluno();
        this.cursos = [
           new Curso('angular2', 'Angular 2'),
           new Curso('javaee', 'Java EE')
        ];    
    }

    /*
    enviar(): {
	this.sucesso = true;
    }
    
    debug(): string {
        return JSON.stringify(this.aluno);
    }
    */

    buildForm(fb: FormBuilder): void {
        this.alunoForm = fb.group({
            nome:['',Validators.required],
            email: ['',Validators.compose([Validators.required, EmailValidator.validate])],
            curso: ['', Validators.required]
        });
    }

    /*
    hasErrors():boolean {
        var hasErrors:boolean = false;

        for(var controlName in this.alunoForm.controls) {
            var control: AbstractControl = this.alunoForm.controls[controlName];
            if(!control.valid && !control.pristine) {
                hasErrors = true;
                break;
            }
        }

        return hasErrors;
    }
    */

    cadastrar() {
        this.alunoService.cadastrar(this.aluno);
        this.aluno = new Aluno();        
    }

    editar(id: number) {
        this.idEditar = id;
        this.aluno = new Aluno(this.alunos[id].nome, this.alunos[id].email, this.alunos[id].idade, this.alunos[id].curso);
    }

    atualizar() {
        this.alunoService.atualizar(this.idEditar, this.aluno);
        this.aluno = new Aluno();
        this.idEditar = -1;
    }

    excluir(id: number) {
        this.alunoService.excluir(id);
        this.idEditar = -1;
    }

}

