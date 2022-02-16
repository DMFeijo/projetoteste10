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
Ent�o o sistema exibea a mensagem "Curso cadastrado com sucesso."

Exemplos: 
| disciplina   | professor      |
| "Portugu�s"  | "Ana Paula"    |
| "Portugu�s"  | "Jo�o Gomes"   |
| "Portugu�s"  | "Carlos Souza" |
| "Matem�tica" | "Ana Paula"    |
| "Matem�tica" | "Jo�o Gomes"   |
| "Matem�tica" | "Carlos Souza" |

Cenario: Validacao de campos obrigatorios
Dado Acessar a pagina de cadastro de curso
Quando solicitar a realizacao do cadastro
Entao sistema exibe para cada campo a mensagem "Campo obrigat�rio"