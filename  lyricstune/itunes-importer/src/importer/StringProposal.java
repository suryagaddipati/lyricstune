/**
 * 
 */
package importer;

import org.eclipse.jface.fieldassist.IContentProposal;

final class StringProposal implements IContentProposal {
	/**
	 * 
	 */
	private final String suggestion;

	public StringProposal(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getContent() {
		return suggestion;
	}

	public int getCursorPosition() {
		return suggestion.length();
	}

	public String getDescription() {
		return null;
	}

	public String getLabel() {
		return suggestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((suggestion == null) ? 0 : suggestion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringProposal other = (StringProposal) obj;
		if (suggestion == null) {
			if (other.suggestion != null)
				return false;
		} else if (!suggestion.equals(other.suggestion))
			return false;
		return true;
	}

	

	
}