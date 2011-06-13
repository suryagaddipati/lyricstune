/**
 * 
 */
package importer;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

public class StringListProvider implements IContentProposalProvider {

	private Set<String> potentialMatches ; 	

	public StringListProvider(Set<String> potentialMatches) {
		super();
		this.potentialMatches = potentialMatches;
	}

	public IContentProposal[] getProposals(String contents, int position) {

		Set<IContentProposal> matchedProposals = new HashSet<IContentProposal>();
		for (String potentialMatch : potentialMatches) {
			String[] tokens = potentialMatch.split(" ");

			for (String token : tokens) {
				if (token.toLowerCase().startsWith(
						contents.toLowerCase())) {
					matchedProposals.add(makeProposal(potentialMatch));
					break;
				}
			}


		}

		return matchedProposals.toArray(new IContentProposal[0]);
	}

	private IContentProposal makeProposal(final String suggestion) {
		return new StringProposal( suggestion);
	}

}