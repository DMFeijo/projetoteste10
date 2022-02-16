#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastro de Cursos
como um usuario do sistema
eu quero realizar cadastro de Cursos
para que eu possa gerenciar Cursos
e professores

Esquema do Cenario: Cadastro de cursos com sucesso
Dado Acessar a pagina de cadastro de curso
E Informar o nome do curso "Intensivo Vestibular"
E Informar a carga horaria "100h"
E Selecionar a disciplina <disciplina>
E Selecionar o professor <professor>
Quando solicitar a realizacao do cadastro
Então o sistema exibea a mensagem "Curso cadastrado com sucesso."

Exemplos: 
| disciplina   | professor      |
| "Português"  | "Ana Paula"    |
| "Português"  | "João Gomes"   |
| "Português"  | "Carlos Souza" |
| "Matemática" | "Ana Paula"    |
| "Matemática" | "João Gomes"   |
| "Matemática" | "Carlos Souza" |

Cenario: Validacao de campos obrigatorios
Dado Acessar a pagina de cadastro de curso
Quando solicitar a realizacao do cadastro
Entao sistema exibe para cada campo a mensagem "Campo obrigatório"