/**
*
* A classe Programa e responsavel pela criacao, abertura e gravacao de objetos do tipo programa
*
* @author Miguel Ramalho, 81948
* @author Miguel Brites, 77982
*
*/

package pex.core;

import pex.parser.*;
import java.util.*;
import java.io.*;
import pt.utl.ist.po.ui.*;
import pex.app.BadPositionException;

public class Program implements Serializable {
	
	//ATRIBUTOS

	/**
	* Nome do programa
	*/

	private String _name;

	/**
	* Expressoes contidas no programa
	*/

	private List<Expression> _expressions; 

	private NewParser _parser;

	//METODOS

	/**
	* Construtor
	*/
	public Program(String name, Interpreter interp) {
		_name = name;
		_expressions = new ArrayList<>();
		_parser = new NewParser(interp);
	}

	/**
	* getName devolve o nome do programa
	* @return _name nome do programa
	*/

	public String getName() { return _name; }

	/**
	* getList devolve a lista de expressoes do programa
	* @return _expressions expressoes do programa
	*/

	public List<Expression> getList() { return _expressions; }

	/**
	* isEquals compara dois programas, retornando true se forem iguais e false se nao forem iguais
	* @param prog programa com quem comparar
	* @return false se forem diferentes, true se forem iguais
	*/

	public NewParser getParser() { return _parser; }

	public boolean isEquals(Program prog) {
		if(_name.equals(prog.getName())){
			if(_expressions.equals(prog.getList()))
				return true; 
		}
		return false;
	}

	public int getArraySize() { return _expressions.size(); }

	/**
	* set atribui as expressoes ao programa
	* @param list lista das expressoes a atribuir
	* 
	*/

	public void set(Collection<Expression> list) { _expressions = (ArrayList<Expression>)list; } 

	/**
	* addExpression adiciona uma expressao ao programa
	* @param idx index da expressao a adicionar
	* @param expression expressao a adicionar
	*/

	public void addExpression(int idx, Expression expression) throws BadPositionException {
		if(idx >= 0 && idx <= _expressions.size())
			_expressions.add(idx, expression);
		else throw new BadPositionException(idx);
	}

	/**
	* replace substitui uma expressao do programa por outra
	* @param idx index da expressao a substituir
	* @þaram expression expressao a substituir
	*/

	public void replace(int idx, Expression expression) throws BadPositionException {
		if(idx > 0 && idx < _expressions.size())
			_expressions.set(idx, expression);
		else throw new BadPositionException(idx);
	}

	/**
	* setIdentifierValue altera o valor do identificador
	* @param id identificador a atribuir
	* @param value valor do identificador
	* @param hmap mapa com os identificadores
	*/


	public Literal execute() {   //how to evaluate all?
		int i;
		EvaluateVisitor v = new EvaluateVisitor();
		if(_expressions.size() > 0) {
			for(i = 0; i<_expressions.size()-1 ; i++) {
			_expressions.get(i).evaluate(v);
			}
		return _expressions.get(i).evaluate(v);
		}
		else
			return new IntegerLiteral(0);
	}

	/**
	* devolve o programa como uma string
	* @return aux string com o programa
	*/

	public String getAsText() { 
		String aux = "";
		for(Expression e: _expressions) {
			aux += e.getAsText() + "\n";
		}
		return aux;
	}
}