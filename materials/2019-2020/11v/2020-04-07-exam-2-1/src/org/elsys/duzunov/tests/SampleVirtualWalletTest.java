package org.elsys.duzunov.tests;

import org.elsys.duzunov.Card;
import org.elsys.duzunov.GoldenCard;
import org.elsys.duzunov.IVirtualWallet;
import org.elsys.duzunov.PaymentInfo;
import org.elsys.duzunov.StandardCard;
import org.elsys.duzunov.VirtualWallet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleVirtualWalletTest {
    private static final double DELTA = 1e-15;

    private static final String STANDARD_CARD = "standard";
    private static final String GOLDEN_CARD = "golden";
    private static final String UNKNOWN_CARD = "unknown";

    private static final double LARGE_FEED_AMOUNT = 100;
    private static final double NEGATIVE_FEED_AMOUNT = -100;

    private static PaymentInfo negativeCostInfo;
    private static StandardCard unknownCard;

    private IVirtualWallet wallet;
    private Card standardCard;
    private Card goldenCard;

    @BeforeAll
    public static void initialize() {
        negativeCostInfo = new PaymentInfo(
                "Happy Bar & Grill",
                "Sofia",
                -50
        );
        unknownCard = new StandardCard(UNKNOWN_CARD);
    }

    @BeforeEach
    public void initializeWalletAndCards() {
        wallet = new VirtualWallet();
        standardCard = new StandardCard(STANDARD_CARD);
        goldenCard = new GoldenCard(GOLDEN_CARD);
    }

    @Test
    public void cardRegistrationSucceeds() {
        assertTrue(wallet.registerCard(standardCard));
        assertEquals(1, wallet.getTotalNumberOfCards());

        Card card = wallet.getCardByName(STANDARD_CARD);
        assertEquals(standardCard, card);
    }

    @Test
    public void cardUnregistrationFailsWhenNullCardIsPassed() {
        assertTrue(wallet.registerCard(standardCard));
        assertFalse(wallet.unregisterCard(null));
        assertEquals(1, wallet.getTotalNumberOfCards());

        Card card = wallet.getCardByName(STANDARD_CARD);
        assertEquals(standardCard, card);
    }

    @Test
    public void paymentFailsWhenNullPaymentInfoIsPassed() {
        assertTrue(wallet.registerCard(standardCard));
        assertTrue(wallet.feed(standardCard, LARGE_FEED_AMOUNT));
        assertFalse(wallet.executePayment(standardCard, null));

        Card card = wallet.getCardByName(GOLDEN_CARD);
        assertEquals(LARGE_FEED_AMOUNT, card.getAmount(), DELTA);
    }

    @Test
    public void paymentFailsWhenNegativeCostIsPassed() {
        assertTrue(wallet.registerCard(goldenCard));
        assertTrue(wallet.feed(goldenCard, LARGE_FEED_AMOUNT));
        assertFalse(wallet.executePayment(goldenCard, negativeCostInfo));

        Card card = wallet.getCardByName(STANDARD_CARD);
        assertEquals(LARGE_FEED_AMOUNT, card.getAmount(), DELTA);
    }

    @Test
    public void feedFailsWhenUnknownCardIsPassed() {
        assertFalse(wallet.feed(unknownCard, LARGE_FEED_AMOUNT));

        assertNull(wallet.getCardByName(UNKNOWN_CARD));
        assertEquals(0, unknownCard.getAmount(), DELTA);
    }

    @Test
    public void feedFailsWhenNegativeAmountIsPassed() {
        assertTrue(wallet.registerCard(standardCard));
        assertFalse(wallet.feed(standardCard, NEGATIVE_FEED_AMOUNT));

        Card card = wallet.getCardByName(STANDARD_CARD);
        assertEquals(0, card.getAmount(), DELTA);
    }
}
