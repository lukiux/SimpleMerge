package detector;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Field;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;

public class SimpleMergeDetector extends OpcodeStackDetector {

	
	final private BugReporter reporter; // yra daug statines analizes irankiu, bent viena kiekvienas kodo redaktorius jau turi integruota
	// pavyzdziui cia warning pabrauktas geltonai, tai ir yra taisykles veikimas
	// mum reiketu pasirinktam irankiui sugalvoti ir prideti savo taisykle
	// pavyzdziui, kad final tipo kitamasis turi prasideti c raide,
	// ir jei taip nera, tada braukia geltonai ir pasiulo i ka pakeisti
	//pvz final int skaicius; -> final int cSKaicius;
	
	//suprnatu, cia kodo yra dar nebaigti apie taisykle. Galiu parodyti ka padariau 
	// findbugs irankius
	
	private String currentClass;
	
	public SimpleMergeDetector(BugReporter reporter) {
		this.reporter = reporter;
	}
	
	public void visit(JavaClass obj) {
		
		currentClass = obj.getClassName();
		for ( Field field : obj.getFields()) {
			
			if (field.isPublic() || field.isPrivate()) {
				String fieldName = "c" + field.getName();
				boolean found = false;
				
				for (Field cField : obj.getFields()) {
					if (cField.getName().equals(fieldName)) {
						found = true;
						break;
					}
				}
				
				if (false == found)
					reporter.reportBug(new BugInstance(this, "UNUSED_LOCAL_VARIABLES_BUG", NORMAL_PRIORITY).addClass(currentClass)
							.addField(this).addString("").addSourceLine(this));
			}			
		}
		super.visit(obj);
	}
	
	
	
	@Override
	public void sawOpcode(int arg0) {
		
	/*	if (arg0 == M_INT) {
			try {
				FieldDescriptor invokedField = getFieldDescriptorOperand();
				ClassDescriptor classDescriptor = invokedField.getClassDescriptor();
				
				if ("java/lang/System".equals(classDescriptor.getClassName()) && 
	                    ("err".equals(invokedField.getName())||"out".equals(invokedField.getName()))) {
	                reportBug();
	            }
				if (invokedField != null && "c".equals(invokedField.getName()) &&
						"simplemerge".equals(classDescriptor.getClassName())) {
					
				}
			} catch (Exception e) {
				
			}
			
			return;
		}*/
		
	}
}
