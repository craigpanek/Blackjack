public class BlackjackGame {

	private final int START_OF_GAME = 1;
	private final int WAITING_TO_DEAL = 2;
	private final int PLAYERS_TURN = 3;
	private final int PLAYER_BUST = 4;
	private final int DEALER_BUST = 5;
	private final int DEALER_WON = 6;
	private final int PUSH = 7;
	private final int PLAYER_WON = 8;
	private Deck deck = new Deck();
	private DealerHand dealerHand;
	private PlayerHand playerHand;
	private int state = START_OF_GAME;
	
	public BlackjackGame() {
		deck.shuffleDeck();
	}
	
	public void reset() {
		state = START_OF_GAME;
		deck.shuffleDeck();
		playerHand = null;
		dealerHand = null;
	}
	
	private void determineOutcome() {
		dealerHand.turnCardsFaceUp();
		int playerTotal = playerHand.getSoftHand();
		int	dealerTotal = dealerHand.getSoftHand();
		if(dealerTotal > 21) {
			state = DEALER_BUST;
			return;
		}
		if(dealerTotal > playerTotal) {
			state = DEALER_WON;
			return;
		}
		if(dealerTotal == playerTotal) {
			state = PUSH;
			return;
		}
		state = PLAYER_WON;
	}
	
	private void dealerPlay() {
		while(dealerHand.getSoftHand() < 18 && dealerHand.getHardHand() < 17) {
			dealerHand.addCard(deck.drawCard());
		}
		determineOutcome();
	}
	
	public void playerStand() {
		dealerPlay();
	}
	
	public void playerHit() {
		if(state == PLAYERS_TURN) {
			playerHand.addCard(deck.drawCard());
			if(playerHand.isBust()) {
				state = PLAYER_BUST;
			}
		}
	}
	
	public void dealCards() {
		if(state != PLAYERS_TURN) {
			dealerHand = new DealerHand();
			playerHand = new PlayerHand();
			if(!deck.isEnoughCardsInDeck()) {
				// insert something here
				System.out.println("Shuffling deck");
				deck.shuffleDeck();
			}
			dealerHand.addCard(deck.drawCard());
			dealerHand.addCard(deck.drawCard().setFaceDown());
			playerHand.addCard(deck.drawCard());
			playerHand.addCard(deck.drawCard());
			state = PLAYERS_TURN;
		}
	}

	public DealerHand getDealerHand() {
		return dealerHand;
	}

	public PlayerHand getPlayerHand() {
		return playerHand;
	}

	public String getMessage1() {
		if(state == START_OF_GAME)
			return "Blackjack";
		else
			return "";
	}
	
	public String getMessage2() {
		if(state == START_OF_GAME)
			return "Press \"deal\" to start game";
		else if(state == WAITING_TO_DEAL)
			return "Press \"Deal\" to continue";
		else if(state == PLAYERS_TURN)
			return "Player's turn";
		else if(state == PLAYER_BUST)
			return "Player busts - Press \"Deal\" to continue";
		else if(state == DEALER_BUST)
			return "Dealer busts - press \"Deal\" to continue";
		else if(state == DEALER_WON)
			return "Dealer won - press \"Deal\" to continue";
		else if(state == PUSH)
			return "Push - press \"Deal\" to continue";
		else if(state == PLAYER_WON)
			return "Player won - press \"Deal\" to continue";
		else
			return "";
	}
}
