package simplemerge;

import net.sourceforge.pmd.lang.java.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class PMDDetector extends AbstractJavaRule{

	@Override
	public Object visit(ASTLocalVariableDeclaration node, Object data) {
		
		System.out.println("hello world");
		addViolation(data, node);
		return super.visit(node, data);
		
	}
	
}
