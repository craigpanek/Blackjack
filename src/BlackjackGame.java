/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

public class BlackjackGame {

	// NEED TO ADD SPLIT FEATURE
	// MIGHT WANT TO HAVE MULTIPLE DECKS
	// MIGHT WANT TO SHOW INFORMATION ABOUT SHUFFLING
	// CAN ENHANCE GUI
	// CAN ADD SOUND

	private final int START_OF_GAME = 1;
	private final int PLAYERS_TURN = 2;
	private final int PLAYER_BUST = 3;
	private final int DEALER_BUST = 4;
	private final int DEALER_WON = 5;
	private final int PUSH = 6;
	private final int PLAYER_WON = 7;
	private final int OUT_OF_MONEY = 8;
	private final int BOTH_HAVE_BLACKJACK = 9;
	private final int DEALER_HAS_BLACKJACK = 10;
	private final int PLAYER_HAS_BLACKJACK = 11;
	private Deck deck = new Deck();
	private DealerHand dealerHand;
	private PlayerHand playerHand;
	private int state = START_OF_GAME;
	private int bet = 0;
	private int previousBet = 0;
	private int balance = 100;

	public BlackjackGame() {
		reset();
	}

	public void reset() {
		balance = 100;
		bet = 0;
		deck.shuffleDeck();
		playerHand = null;
		dealerHand = null;
		state = START_OF_GAME;
	}

	private void determineOutcome() {
		dealerHand.turnCardsFaceUp();
		int playerTotal = playerHand.getSoftHand();
		int dealerTotal = dealerHand.getSoftHand();
		if (dealerTotal > 21) {
			state = DEALER_BUST;
			balance += bet;
		} else if (dealerTotal > playerTotal) {
			state = DEALER_WON;
			balance -= bet;
		} else if (dealerTotal == playerTotal) {
			state = PUSH;
		} else {
			state = PLAYER_WON;
			balance += bet;
		}
		bet = 0;
	}

	public void doubleDown() {
		if(state == PLAYERS_TURN && playerHand.getCards().size() == 2
				&& (balance >= (2 * bet))) {
			bet *= 2;
			playerHit();
			if(state != PLAYER_BUST)
				dealerPlay();
		}
	}
	
	private void checkForBlackjacks() {
		// if both dealer and player have blackjack, it's a push
		if(dealerHand.isBlackjack() && playerHand.isBlackjack()) {
			state = BOTH_HAVE_BLACKJACK;
			dealerHand.showDealerDownCard();
			bet = 0;
		} else if(dealerHand.isBlackjack()) {
			state = DEALER_HAS_BLACKJACK;
			dealerHand.showDealerDownCard();
			balance -= bet;
			bet = 0;
		} else if(playerHand.isBlackjack()) {
			state = PLAYER_HAS_BLACKJACK;
			dealerHand.showDealerDownCard();
			balance += bet;
			bet = 0;
		}
	}
	
	private void dealerPlay() {
		while (dealerHand.getSoftHand() < 18 && dealerHand.getHardHand() < 17) {
			dealerHand.addCard(deck.drawCard());
		}
		determineOutcome();
	}

	public void playerStand() {
		if (state == PLAYERS_TURN)
			dealerPlay();
	}

	public void playerHit() {
		if (state == PLAYERS_TURN) {
			playerHand.addCard(deck.drawCard());
			if (playerHand.isBust()) {
				state = PLAYER_BUST;
				balance -= bet;
				bet = 0;
				dealerHand.showDealerDownCard();
			}
		}
	}

	private void checkForGameOver() {
		if (balance <= 0) {
			state = OUT_OF_MONEY;
		}
	}

	public void dealCards() {
		if (state != PLAYERS_TURN && state != OUT_OF_MONEY && (getBet() != 0)) {
			previousBet = bet;
			dealerHand = new DealerHand();
			playerHand = new PlayerHand();
			if (!deck.isEnoughCardsInDeck()) {
				// insert something here
				System.out.println("Shuffling deck");
				deck.shuffleDeck();
			}
			dealerHand.addCard(deck.drawCard());
			dealerHand.addCard(deck.drawCard().setFaceDown());
			playerHand.addCard(deck.drawCard());
			playerHand.addCard(deck.drawCard());
			state = PLAYERS_TURN;
			checkForBlackjacks();
		}
	}

	public DealerHand getDealerHand() {
		return dealerHand;
	}

	public PlayerHand getPlayerHand() {
		return playerHand;
	}

	public String getMessage1() {
		if (state == START_OF_GAME)
			return "Blackjack";
		else
			return "";
	}

	public String getMessage2() {
		if (state == START_OF_GAME)
			return "Press \"Deal\" after betting";
		else if(state == BOTH_HAVE_BLACKJACK)
			return "Both have blackjack.  Push.  Press \"Deal\" after betting";
		else if(state == DEALER_HAS_BLACKJACK)
			return "Dealer has blackjack.  Dealer wins. Press \"Deal\" " 
					+ "after betting";
		else if(state == PLAYER_HAS_BLACKJACK)
			return "Player has blackjack.  Player wins. Press \"Deal\" "
					+ "after betting";
		else if (state == PLAYERS_TURN)
			return "Player's turn";
		else if (state == PLAYER_BUST)
			return "Player busts.  Press \"Deal\" after betting";
		else if (state == DEALER_BUST)
			return "Dealer busts.  Press \"Deal\" after betting";
		else if (state == DEALER_WON)
			return "Dealer wins.  Press \"Deal\" after betting";
		else if (state == PUSH)
			return "Push.  Press \"Deal\" after betting";
		else if (state == PLAYER_WON)
			return "Player wins.  Press \"Deal\" after betting";
		else if (state == OUT_OF_MONEY)
			return "Sorry you are out of money!";
		else
			return "";
	}

	public void clearBet() {
		setBet(0);
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		checkForGameOver();
		if (state != OUT_OF_MONEY && state != PLAYERS_TURN
				&& balance >= bet)
			this.bet = bet;
	}

	public int getPreviousBet() {
		return previousBet;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
