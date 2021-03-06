package logic.deduction;

import game.Game;

import java.util.ArrayList;
import java.util.List;

import logic.Reason;
import logic.conclusion.Conclusion;
import logic.conclusion.PlayerDefinitelyDoesHaveCardConclusion;
import player.Player;
import card.Card;

/**
 * If all but one player has a card, that player must have the card
 * @author Kapil
 */
public class HorizontalUniquenessInverseDeduction implements Deduction {

	@Override
	public List<Conclusion> run(Game game) {
		List<Conclusion> conclusions = new ArrayList<>();
		
		for (Card card : game.getState().getCardList().getAll()) {
			run(game, conclusions, card);
		}
		
		return conclusions;
	}
	
	private void run(Game game, List<Conclusion> conclusions, Card card) {
		Player unknownPlayer = null;
		
		for (Player player : game.getState().getPlayers()) {
			switch (game.getInfo().getChecklist().getValue(player, card)) {
			case DEFINITELY_DOES_HAVE:
				//somebody has this card, we can't get any info about it
				return;
			case DEFINITELY_DOES_NOT_HAVE:
				//do nothing
				break;
			case UNKNOWN:
				if (unknownPlayer != null) {
					//there are two players whos ownership we don't know, so we can't get any info
					return;
				}
				else {
					unknownPlayer = player;
				}
			}
		}
		
		/*
		 * if we haven't returned by here, then exactly one player has an UNKNOWN
		 * ownership of the card, and the rest of the player definitely do NOT have the card
		 */
		conclusions.add(new PlayerDefinitelyDoesHaveCardConclusion(
			unknownPlayer, card,
			Reason.NOBODY_ELSE_HAS_CARD
		));
	}

}
