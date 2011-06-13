/**
 * 
 */
package importer;

import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

class TextContentAdapter implements IControlContentAdapter{

	public String getControlContents(Control control) {
		return ((Text)control).getText();
	}

	public int getCursorPosition(Control control) {
		return ((Text) control).getSelection().x;
	}

	public Rectangle getInsertionBounds(Control control) {
		Text combo = (Text) control;
		int position = combo.getSelection().y;
		String contents = combo.getText();
		GC gc = new GC(combo);
		gc.setFont(combo.getFont());
		Point extent = gc.textExtent(contents.substring(0, Math.min(position,
				contents.length())));
		gc.dispose();
		return new Rectangle(combo.getClientArea().x + extent.x, combo
				.getClientArea().y, 1, combo.getClientArea().height);
	}

	public void insertControlContents(Control control, String text,
			int cursorPosition) {
		setControlContents(control, text, cursorPosition);
//		Text combo = (Text) control;
//		String contents = combo.getText();
//		Point selection = combo.getSelection();
//		StringBuffer sb = new StringBuffer();
//		sb.append(contents.substring(0, selection.x));
//		sb.append(text);
//		if (selection.y < contents.length()) {
//			sb.append(contents.substring(selection.y, contents.length()));
//		}
//		combo.setText(sb.toString());
//		selection.x = selection.x + cursorPosition;
//		selection.y = selection.x;
//		combo.setSelection(selection);
		
	}

	public void setControlContents(Control control, String contents,
			int cursorPosition) {
		((Text) control).setText(contents);
		((Text) control)
				.setSelection(new Point(cursorPosition, cursorPosition));
		
	}

	public void setCursorPosition(Control control, int index) {
		((Text) control).setSelection(new Point(index, index));
		
	}
	
}