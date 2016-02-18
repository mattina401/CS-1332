import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
//import struct.worth;
import org.junit.Before;
import org.junit.Test;

import struct.Worth;

public class StrictTests {
	private BST<Integer> bst;
	private AVL<Integer> avl;
	private static final int TIMEOUT = 250;

	@Before
	public void setup() {
		bst = new BST<Integer>();
		avl = new AVL<Integer>();
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst1() {
		bst.add(null);
		bst.add(256);
		bst.add(-442);
		bst.add(-440);
		bst.add(130);
		bst.add(203);
		bst.add(-214);
		bst.add(417);
		bst.add(-393);
		bst.add(-135);

		assertTrue(bst.contains(null));
		assertTrue(bst.contains(256));
		assertTrue(bst.contains(-442));
		assertTrue(bst.contains(-440));
		assertTrue(bst.contains(130));
		assertTrue(bst.contains(203));
		assertTrue(bst.contains(-214));
		assertTrue(bst.contains(417));
		assertTrue(bst.contains(-393));
		assertTrue(bst.contains(-135));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst2() {
		bst.add(-158);
		bst.add(335);
		bst.add(142);
		bst.add(374);
		bst.add(-297);
		bst.add(-153);
		bst.add(-38);
		bst.add(-370);
		bst.add(-399);
		bst.add(-340);

		assertTrue(bst.contains(-158));
		assertTrue(bst.contains(335));
		assertTrue(bst.contains(142));
		assertTrue(bst.contains(374));
		assertTrue(bst.contains(-297));
		assertTrue(bst.contains(-153));
		assertTrue(bst.contains(-38));
		assertTrue(bst.contains(-370));
		assertTrue(bst.contains(-399));
		assertTrue(bst.contains(-340));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst3() {
		bst.add(377);
		bst.add(314);
		bst.add(-286);
		bst.add(Integer.MAX_VALUE);
		bst.add(-90);
		bst.add(null);
		bst.add(-78);
		bst.add(31);
		bst.add(-165);
		bst.add(260);
		bst.add(280);
		bst.add(-54);
		bst.add(-214);

		assertTrue(bst.contains(377));
		assertTrue(bst.contains(314));
		assertTrue(bst.contains(-286));
		assertTrue(bst.contains(Integer.MAX_VALUE));
		assertTrue(bst.contains(-90));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(-78));
		assertTrue(bst.contains(31));
		assertTrue(bst.contains(-165));
		assertTrue(bst.contains(260));
		assertTrue(bst.contains(280));
		assertTrue(bst.contains(-54));
		assertTrue(bst.contains(-214));
		assertEquals(13, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst4() {
		bst.add(-176);
		bst.add(-194);
		bst.add(256);
		bst.add(-21);
		bst.add(-13);
		bst.add(-120);
		bst.add(-291);
		bst.add(-119);
		bst.add(-134);
		bst.add(-182);
		bst.add(-423);

		assertTrue(bst.contains(-176));
		assertTrue(bst.contains(-194));
		assertTrue(bst.contains(256));
		assertTrue(bst.contains(-21));
		assertTrue(bst.contains(-13));
		assertTrue(bst.contains(-120));
		assertTrue(bst.contains(-291));
		assertTrue(bst.contains(-119));
		assertTrue(bst.contains(-134));
		assertTrue(bst.contains(-182));
		assertTrue(bst.contains(-423));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst5() {
		bst.add(-287);
		bst.add(149);
		bst.add(-356);
		bst.add(224);
		bst.add(280);
		bst.add(28);
		bst.add(499);
		bst.add(428);
		bst.add(56);
		bst.add(-411);
		bst.add(109);
		bst.add(381);
		bst.add(84);
		bst.add(null);
		bst.add(-421);

		assertTrue(bst.contains(-287));
		assertTrue(bst.contains(149));
		assertTrue(bst.contains(-356));
		assertTrue(bst.contains(224));
		assertTrue(bst.contains(280));
		assertTrue(bst.contains(28));
		assertTrue(bst.contains(499));
		assertTrue(bst.contains(428));
		assertTrue(bst.contains(56));
		assertTrue(bst.contains(-411));
		assertTrue(bst.contains(109));
		assertTrue(bst.contains(381));
		assertTrue(bst.contains(84));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(-421));
		assertEquals(15, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst6() {
		bst.add(287);
		bst.add(-351);
		bst.add(-225);
		bst.add(-464);
		bst.add(200);
		bst.add(-432);
		bst.add(423);
		bst.add(-299);
		bst.add(457);
		bst.add(190);
		bst.add(257);

		assertTrue(bst.contains(287));
		assertTrue(bst.contains(-351));
		assertTrue(bst.contains(-225));
		assertTrue(bst.contains(-464));
		assertTrue(bst.contains(200));
		assertTrue(bst.contains(-432));
		assertTrue(bst.contains(423));
		assertTrue(bst.contains(-299));
		assertTrue(bst.contains(457));
		assertTrue(bst.contains(190));
		assertTrue(bst.contains(257));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst7() {
		bst.add(51);
		bst.add(327);
		bst.add(-87);
		bst.add(127);
		bst.add(-373);
		bst.add(-153);
		bst.add(null);
		bst.add(248);
		bst.add(-164);
		bst.add(-458);
		bst.add(-152);
		bst.add(-184);
		bst.add(-15);
		bst.add(-323);

		assertTrue(bst.contains(51));
		assertTrue(bst.contains(327));
		assertTrue(bst.contains(-87));
		assertTrue(bst.contains(127));
		assertTrue(bst.contains(-373));
		assertTrue(bst.contains(-153));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(248));
		assertTrue(bst.contains(-164));
		assertTrue(bst.contains(-458));
		assertTrue(bst.contains(-152));
		assertTrue(bst.contains(-184));
		assertTrue(bst.contains(-15));
		assertTrue(bst.contains(-323));
		assertEquals(14, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst8() {
		bst.add(Integer.MIN_VALUE);
		bst.add(-29);
		bst.add(421);
		bst.add(-317);
		bst.add(null);
		bst.add(7);
		bst.add(-178);
		bst.add(-314);
		bst.add(483);
		bst.add(317);

		assertTrue(bst.contains(Integer.MIN_VALUE));
		assertTrue(bst.contains(-29));
		assertTrue(bst.contains(421));
		assertTrue(bst.contains(-317));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(7));
		assertTrue(bst.contains(-178));
		assertTrue(bst.contains(-314));
		assertTrue(bst.contains(483));
		assertTrue(bst.contains(317));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst9() {
		bst.add(12);
		bst.add(198);
		bst.add(-5);
		bst.add(172);
		bst.add(-151);
		bst.add(-110);
		bst.add(-486);
		bst.add(-294);
		bst.add(-495);
		bst.add(401);
		bst.add(230);

		assertTrue(bst.contains(12));
		assertTrue(bst.contains(198));
		assertTrue(bst.contains(-5));
		assertTrue(bst.contains(172));
		assertTrue(bst.contains(-151));
		assertTrue(bst.contains(-110));
		assertTrue(bst.contains(-486));
		assertTrue(bst.contains(-294));
		assertTrue(bst.contains(-495));
		assertTrue(bst.contains(401));
		assertTrue(bst.contains(230));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst10() {
		bst.add(-341);
		bst.add(-119);
		bst.add(-423);
		bst.add(446);
		bst.add(348);
		bst.add(10);
		bst.add(-156);
		bst.add(271);
		bst.add(249);
		bst.add(376);
		bst.add(373);
		bst.add(-343);

		assertTrue(bst.contains(-341));
		assertTrue(bst.contains(-119));
		assertTrue(bst.contains(-423));
		assertTrue(bst.contains(446));
		assertTrue(bst.contains(348));
		assertTrue(bst.contains(10));
		assertTrue(bst.contains(-156));
		assertTrue(bst.contains(271));
		assertTrue(bst.contains(249));
		assertTrue(bst.contains(376));
		assertTrue(bst.contains(373));
		assertTrue(bst.contains(-343));
		assertEquals(12, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst11() {
		bst.add(329);
		bst.add(16);
		bst.add(-148);
		bst.add(-343);
		bst.add(105);
		bst.add(-188);
		bst.add(54);
		bst.add(353);
		bst.add(86);
		bst.add(272);
		bst.add(36);
		bst.add(150);

		assertTrue(bst.contains(329));
		assertTrue(bst.contains(16));
		assertTrue(bst.contains(-148));
		assertTrue(bst.contains(-343));
		assertTrue(bst.contains(105));
		assertTrue(bst.contains(-188));
		assertTrue(bst.contains(54));
		assertTrue(bst.contains(353));
		assertTrue(bst.contains(86));
		assertTrue(bst.contains(272));
		assertTrue(bst.contains(36));
		assertTrue(bst.contains(150));
		assertEquals(12, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst12() {
		bst.add(250);
		bst.add(221);
		bst.add(-61);
		bst.add(187);
		bst.add(467);
		bst.add(-382);
		bst.add(43);
		bst.add(-264);
		bst.add(-272);
		bst.add(414);
		bst.add(-442);
		bst.add(457);
		bst.add(-215);
		bst.add(320);

		assertTrue(bst.contains(250));
		assertTrue(bst.contains(221));
		assertTrue(bst.contains(-61));
		assertTrue(bst.contains(187));
		assertTrue(bst.contains(467));
		assertTrue(bst.contains(-382));
		assertTrue(bst.contains(43));
		assertTrue(bst.contains(-264));
		assertTrue(bst.contains(-272));
		assertTrue(bst.contains(414));
		assertTrue(bst.contains(-442));
		assertTrue(bst.contains(457));
		assertTrue(bst.contains(-215));
		assertTrue(bst.contains(320));
		assertEquals(14, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst13() {
		bst.add(159);
		bst.add(47);
		bst.add(-239);
		bst.add(-245);
		bst.add(364);
		bst.add(-101);
		bst.add(-43);
		bst.add(249);
		bst.add(332);
		bst.add(-214);
		bst.add(485);

		assertTrue(bst.contains(159));
		assertTrue(bst.contains(47));
		assertTrue(bst.contains(-239));
		assertTrue(bst.contains(-245));
		assertTrue(bst.contains(364));
		assertTrue(bst.contains(-101));
		assertTrue(bst.contains(-43));
		assertTrue(bst.contains(249));
		assertTrue(bst.contains(332));
		assertTrue(bst.contains(-214));
		assertTrue(bst.contains(485));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst14() {
		bst.add(-421);
		bst.add(-256);
		bst.add(-5);
		bst.add(-203);
		bst.add(-23);
		bst.add(323);
		bst.add(481);
		bst.add(365);
		bst.add(-361);
		bst.add(250);
		bst.add(-431);
		bst.add(-129);
		bst.add(260);
		bst.add(-445);

		assertTrue(bst.contains(-421));
		assertTrue(bst.contains(-256));
		assertTrue(bst.contains(-5));
		assertTrue(bst.contains(-203));
		assertTrue(bst.contains(-23));
		assertTrue(bst.contains(323));
		assertTrue(bst.contains(481));
		assertTrue(bst.contains(365));
		assertTrue(bst.contains(-361));
		assertTrue(bst.contains(250));
		assertTrue(bst.contains(-431));
		assertTrue(bst.contains(-129));
		assertTrue(bst.contains(260));
		assertTrue(bst.contains(-445));
		assertEquals(14, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst15() {
		bst.add(414);
		bst.add(425);
		bst.add(-135);
		bst.add(196);
		bst.add(-408);
		bst.add(-133);
		bst.add(61);
		bst.add(-261);
		bst.add(-319);
		bst.add(318);
		bst.add(-375);
		bst.add(-27);
		bst.add(-457);

		assertTrue(bst.contains(414));
		assertTrue(bst.contains(425));
		assertTrue(bst.contains(-135));
		assertTrue(bst.contains(196));
		assertTrue(bst.contains(-408));
		assertTrue(bst.contains(-133));
		assertTrue(bst.contains(61));
		assertTrue(bst.contains(-261));
		assertTrue(bst.contains(-319));
		assertTrue(bst.contains(318));
		assertTrue(bst.contains(-375));
		assertTrue(bst.contains(-27));
		assertTrue(bst.contains(-457));
		assertEquals(13, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst16() {
		bst.add(-88);
		bst.add(-226);
		bst.add(346);
		bst.add(-356);
		bst.add(-360);
		bst.add(-371);
		bst.add(139);
		bst.add(-396);
		bst.add(402);
		bst.add(425);
		bst.add(-287);
		bst.add(151);
		bst.add(-294);

		assertTrue(bst.contains(-88));
		assertTrue(bst.contains(-226));
		assertTrue(bst.contains(346));
		assertTrue(bst.contains(-356));
		assertTrue(bst.contains(-360));
		assertTrue(bst.contains(-371));
		assertTrue(bst.contains(139));
		assertTrue(bst.contains(-396));
		assertTrue(bst.contains(402));
		assertTrue(bst.contains(425));
		assertTrue(bst.contains(-287));
		assertTrue(bst.contains(151));
		assertTrue(bst.contains(-294));
		assertEquals(13, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst17() {
		bst.add(-316);
		bst.add(234);
		bst.add(-275);
		bst.add(12);
		bst.add(-376);
		bst.add(-240);
		bst.add(3);
		bst.add(149);
		bst.add(-254);
		bst.add(-391);

		assertTrue(bst.contains(-316));
		assertTrue(bst.contains(234));
		assertTrue(bst.contains(-275));
		assertTrue(bst.contains(12));
		assertTrue(bst.contains(-376));
		assertTrue(bst.contains(-240));
		assertTrue(bst.contains(3));
		assertTrue(bst.contains(149));
		assertTrue(bst.contains(-254));
		assertTrue(bst.contains(-391));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst18() {
		bst.add(-55);
		bst.add(-86);
		bst.add(49);
		bst.add(-173);
		bst.add(134);
		bst.add(363);
		bst.add(-441);
		bst.add(380);
		bst.add(474);
		bst.add(-326);
		bst.add(-230);
		bst.add(-353);
		bst.add(-365);
		bst.add(-156);
		bst.add(-354);

		assertTrue(bst.contains(-55));
		assertTrue(bst.contains(-86));
		assertTrue(bst.contains(49));
		assertTrue(bst.contains(-173));
		assertTrue(bst.contains(134));
		assertTrue(bst.contains(363));
		assertTrue(bst.contains(-441));
		assertTrue(bst.contains(380));
		assertTrue(bst.contains(474));
		assertTrue(bst.contains(-326));
		assertTrue(bst.contains(-230));
		assertTrue(bst.contains(-353));
		assertTrue(bst.contains(-365));
		assertTrue(bst.contains(-156));
		assertTrue(bst.contains(-354));
		assertEquals(15, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst19() {
		bst.add(-408);
		bst.add(47);
		bst.add(419);
		bst.add(-340);
		bst.add(-30);
		bst.add(177);
		bst.add(-328);
		bst.add(-315);
		bst.add(-432);
		bst.add(-321);

		assertTrue(bst.contains(-408));
		assertTrue(bst.contains(47));
		assertTrue(bst.contains(419));
		assertTrue(bst.contains(-340));
		assertTrue(bst.contains(-30));
		assertTrue(bst.contains(177));
		assertTrue(bst.contains(-328));
		assertTrue(bst.contains(-315));
		assertTrue(bst.contains(-432));
		assertTrue(bst.contains(-321));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestbst20() {
		bst.add(-403);
		bst.add(-191);
		bst.add(-90);
		bst.add(-71);
		bst.add(133);
		bst.add(-31);
		bst.add(-182);
		bst.add(296);
		bst.add(312);
		bst.add(-81);
		bst.add(62);
		bst.add(121);
		bst.add(-500);

		assertTrue(bst.contains(-403));
		assertTrue(bst.contains(-191));
		assertTrue(bst.contains(-90));
		assertTrue(bst.contains(-71));
		assertTrue(bst.contains(133));
		assertTrue(bst.contains(-31));
		assertTrue(bst.contains(-182));
		assertTrue(bst.contains(296));
		assertTrue(bst.contains(312));
		assertTrue(bst.contains(-81));
		assertTrue(bst.contains(62));
		assertTrue(bst.contains(121));
		assertTrue(bst.contains(-500));
		assertEquals(13, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl1() {
		avl.add(null);
		avl.add(-360);
		avl.add(133);
		avl.add(404);
		avl.add(-13);
		avl.add(-114);
		avl.add(-459);
		avl.add(-73);
		avl.add(291);
		avl.add(-466);
		avl.add(-74);
		avl.add(320);
		avl.add(389);
		avl.add(219);

		assertTrue(avl.contains(null));
		assertTrue(avl.contains(-360));
		assertTrue(avl.contains(133));
		assertTrue(avl.contains(404));
		assertTrue(avl.contains(-13));
		assertTrue(avl.contains(-114));
		assertTrue(avl.contains(-459));
		assertTrue(avl.contains(-73));
		assertTrue(avl.contains(291));
		assertTrue(avl.contains(-466));
		assertTrue(avl.contains(-74));
		assertTrue(avl.contains(320));
		assertTrue(avl.contains(389));
		assertTrue(avl.contains(219));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl2() {
		avl.add(313);
		avl.add(193);
		avl.add(-59);
		avl.add(167);
		avl.add(-484);
		avl.add(372);
		avl.add(-6);
		avl.add(-70);
		avl.add(null);
		avl.add(-176);
		avl.add(254);
		avl.add(396);
		avl.add(479);
		avl.add(44);
		avl.add(201);

		assertTrue(avl.contains(313));
		assertTrue(avl.contains(193));
		assertTrue(avl.contains(-59));
		assertTrue(avl.contains(167));
		assertTrue(avl.contains(-484));
		assertTrue(avl.contains(372));
		assertTrue(avl.contains(-6));
		assertTrue(avl.contains(-70));
		assertTrue(avl.contains(null));
		assertTrue(avl.contains(-176));
		assertTrue(avl.contains(254));
		assertTrue(avl.contains(396));
		assertTrue(avl.contains(479));
		assertTrue(avl.contains(44));
		assertTrue(avl.contains(201));
		assertEquals(15, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl3() {
		avl.add(-147);
		avl.add(-129);
		avl.add(-112);
		avl.add(269);
		avl.add(-348);
		avl.add(-318);
		avl.add(38);
		avl.add(-455);
		avl.add(121);
		avl.add(-37);
		avl.add(-486);
		avl.add(-249);
		avl.add(160);
		avl.add(null);

		assertTrue(avl.contains(-147));
		assertTrue(avl.contains(-129));
		assertTrue(avl.contains(-112));
		assertTrue(avl.contains(269));
		assertTrue(avl.contains(-348));
		assertTrue(avl.contains(-318));
		assertTrue(avl.contains(38));
		assertTrue(avl.contains(-455));
		assertTrue(avl.contains(121));
		assertTrue(avl.contains(-37));
		assertTrue(avl.contains(-486));
		assertTrue(avl.contains(-249));
		assertTrue(avl.contains(160));
		assertTrue(avl.contains(null));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl4() {
		avl.add(-157);
		avl.add(-17);
		avl.add(335);
		avl.add(-495);
		avl.add(96);
		avl.add(204);
		avl.add(-134);
		avl.add(-292);
		avl.add(-381);
		avl.add(-500);
		avl.add(157);

		assertTrue(avl.contains(-157));
		assertTrue(avl.contains(-17));
		assertTrue(avl.contains(335));
		assertTrue(avl.contains(-495));
		assertTrue(avl.contains(96));
		assertTrue(avl.contains(204));
		assertTrue(avl.contains(-134));
		assertTrue(avl.contains(-292));
		assertTrue(avl.contains(-381));
		assertTrue(avl.contains(-500));
		assertTrue(avl.contains(157));
		assertEquals(11, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl5() {
		avl.add(-178);
		avl.add(38);
		avl.add(-449);
		avl.add(416);
		avl.add(-485);
		avl.add(115);
		avl.add(-269);
		avl.add(-408);
		avl.add(15);
		avl.add(-432);
		avl.add(-392);
		avl.add(31);
		avl.add(231);
		avl.add(-332);

		assertTrue(avl.contains(-178));
		assertTrue(avl.contains(38));
		assertTrue(avl.contains(-449));
		assertTrue(avl.contains(416));
		assertTrue(avl.contains(-485));
		assertTrue(avl.contains(115));
		assertTrue(avl.contains(-269));
		assertTrue(avl.contains(-408));
		assertTrue(avl.contains(15));
		assertTrue(avl.contains(-432));
		assertTrue(avl.contains(-392));
		assertTrue(avl.contains(31));
		assertTrue(avl.contains(231));
		assertTrue(avl.contains(-332));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl6() {
		avl.add(-310);
		avl.add(79);
		avl.add(403);
		avl.add(-113);
		avl.add(-93);
		avl.add(-318);
		avl.add(351);
		avl.add(-414);
		avl.add(-132);
		avl.add(-283);
		avl.add(83);
		avl.add(-139);
		avl.add(-279);

		assertTrue(avl.contains(-310));
		assertTrue(avl.contains(79));
		assertTrue(avl.contains(403));
		assertTrue(avl.contains(-113));
		assertTrue(avl.contains(-93));
		assertTrue(avl.contains(-318));
		assertTrue(avl.contains(351));
		assertTrue(avl.contains(-414));
		assertTrue(avl.contains(-132));
		assertTrue(avl.contains(-283));
		assertTrue(avl.contains(83));
		assertTrue(avl.contains(-139));
		assertTrue(avl.contains(-279));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl7() {
		avl.add(-439);
		avl.add(-371);
		avl.add(257);
		avl.add(144);
		avl.add(129);
		avl.add(489);
		avl.add(312);
		avl.add(239);
		avl.add(-422);
		avl.add(232);
		avl.add(-251);

		assertTrue(avl.contains(-439));
		assertTrue(avl.contains(-371));
		assertTrue(avl.contains(257));
		assertTrue(avl.contains(144));
		assertTrue(avl.contains(129));
		assertTrue(avl.contains(489));
		assertTrue(avl.contains(312));
		assertTrue(avl.contains(239));
		assertTrue(avl.contains(-422));
		assertTrue(avl.contains(232));
		assertTrue(avl.contains(-251));
		assertEquals(11, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl8() {
		avl.add(128);
		avl.add(-110);
		avl.add(-293);
		avl.add(-427);
		avl.add(284);
		avl.add(-437);
		avl.add(-26);
		avl.add(242);
		avl.add(-347);
		avl.add(-119);
		avl.add(429);
		avl.add(380);
		avl.add(302);
		avl.add(-282);
		avl.add(495);

		assertTrue(avl.contains(128));
		assertTrue(avl.contains(-110));
		assertTrue(avl.contains(-293));
		assertTrue(avl.contains(-427));
		assertTrue(avl.contains(284));
		assertTrue(avl.contains(-437));
		assertTrue(avl.contains(-26));
		assertTrue(avl.contains(242));
		assertTrue(avl.contains(-347));
		assertTrue(avl.contains(-119));
		assertTrue(avl.contains(429));
		assertTrue(avl.contains(380));
		assertTrue(avl.contains(302));
		assertTrue(avl.contains(-282));
		assertTrue(avl.contains(495));
		assertEquals(15, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl9() {
		avl.add(-446);
		avl.add(-204);
		avl.add(-482);
		avl.add(-103);
		avl.add(-425);
		avl.add(308);
		avl.add(-379);
		avl.add(-180);
		avl.add(-244);
		avl.add(-46);
		avl.add(253);
		avl.add(317);
		avl.add(-466);

		assertTrue(avl.contains(-446));
		assertTrue(avl.contains(-204));
		assertTrue(avl.contains(-482));
		assertTrue(avl.contains(-103));
		assertTrue(avl.contains(-425));
		assertTrue(avl.contains(308));
		assertTrue(avl.contains(-379));
		assertTrue(avl.contains(-180));
		assertTrue(avl.contains(-244));
		assertTrue(avl.contains(-46));
		assertTrue(avl.contains(253));
		assertTrue(avl.contains(317));
		assertTrue(avl.contains(-466));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl10() {
		avl.add(-19);
		avl.add(-215);
		avl.add(180);
		avl.add(221);
		avl.add(408);
		avl.add(-439);
		avl.add(209);
		avl.add(-245);
		avl.add(78);
		avl.add(-442);
		avl.add(-15);
		avl.add(21);
		avl.add(-473);
		avl.add(179);

		assertTrue(avl.contains(-19));
		assertTrue(avl.contains(-215));
		assertTrue(avl.contains(180));
		assertTrue(avl.contains(221));
		assertTrue(avl.contains(408));
		assertTrue(avl.contains(-439));
		assertTrue(avl.contains(209));
		assertTrue(avl.contains(-245));
		assertTrue(avl.contains(78));
		assertTrue(avl.contains(-442));
		assertTrue(avl.contains(-15));
		assertTrue(avl.contains(21));
		assertTrue(avl.contains(-473));
		assertTrue(avl.contains(179));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl11() {
		avl.add(-177);
		avl.add(-196);
		avl.add(-457);
		avl.add(285);
		avl.add(-209);
		avl.add(-460);
		avl.add(-261);
		avl.add(-188);
		avl.add(338);
		avl.add(274);
		avl.add(5);
		avl.add(90);
		avl.add(301);
		avl.add(348);

		assertTrue(avl.contains(-177));
		assertTrue(avl.contains(-196));
		assertTrue(avl.contains(-457));
		assertTrue(avl.contains(285));
		assertTrue(avl.contains(-209));
		assertTrue(avl.contains(-460));
		assertTrue(avl.contains(-261));
		assertTrue(avl.contains(-188));
		assertTrue(avl.contains(338));
		assertTrue(avl.contains(274));
		assertTrue(avl.contains(5));
		assertTrue(avl.contains(90));
		assertTrue(avl.contains(301));
		assertTrue(avl.contains(348));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl12() {
		avl.add(-359);
		avl.add(293);
		avl.add(-145);
		avl.add(-21);
		avl.add(-105);
		avl.add(409);
		avl.add(-57);
		avl.add(-406);
		avl.add(62);
		avl.add(69);
		avl.add(351);
		avl.add(-150);
		avl.add(-176);

		assertTrue(avl.contains(-359));
		assertTrue(avl.contains(293));
		assertTrue(avl.contains(-145));
		assertTrue(avl.contains(-21));
		assertTrue(avl.contains(-105));
		assertTrue(avl.contains(409));
		assertTrue(avl.contains(-57));
		assertTrue(avl.contains(-406));
		assertTrue(avl.contains(62));
		assertTrue(avl.contains(69));
		assertTrue(avl.contains(351));
		assertTrue(avl.contains(-150));
		assertTrue(avl.contains(-176));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl13() {
		avl.add(-182);
		avl.add(-263);
		avl.add(-192);
		avl.add(-271);
		avl.add(326);
		avl.add(-403);
		avl.add(-498);
		avl.add(-132);
		avl.add(-58);
		avl.add(229);
		avl.add(237);
		avl.add(-321);
		avl.add(367);
		avl.add(85);
		avl.add(-373);

		assertTrue(avl.contains(-182));
		assertTrue(avl.contains(-263));
		assertTrue(avl.contains(-192));
		assertTrue(avl.contains(-271));
		assertTrue(avl.contains(326));
		assertTrue(avl.contains(-403));
		assertTrue(avl.contains(-498));
		assertTrue(avl.contains(-132));
		assertTrue(avl.contains(-58));
		assertTrue(avl.contains(229));
		assertTrue(avl.contains(237));
		assertTrue(avl.contains(-321));
		assertTrue(avl.contains(367));
		assertTrue(avl.contains(85));
		assertTrue(avl.contains(-373));
		assertEquals(15, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl14() {
		avl.add(218);
		avl.add(77);
		avl.add(248);
		avl.add(80);
		avl.add(-261);
		avl.add(24);
		avl.add(-292);
		avl.add(75);
		avl.add(379);
		avl.add(225);
		avl.add(-278);
		avl.add(-130);
		avl.add(-242);

		assertTrue(avl.contains(218));
		assertTrue(avl.contains(77));
		assertTrue(avl.contains(248));
		assertTrue(avl.contains(80));
		assertTrue(avl.contains(-261));
		assertTrue(avl.contains(24));
		assertTrue(avl.contains(-292));
		assertTrue(avl.contains(75));
		assertTrue(avl.contains(379));
		assertTrue(avl.contains(225));
		assertTrue(avl.contains(-278));
		assertTrue(avl.contains(-130));
		assertTrue(avl.contains(-242));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl15() {
		avl.add(-396);
		avl.add(-456);
		avl.add(-86);
		avl.add(310);
		avl.add(-229);
		avl.add(428);
		avl.add(449);
		avl.add(-424);
		avl.add(-48);
		avl.add(347);
		avl.add(-342);
		avl.add(1);
		avl.add(-118);

		assertTrue(avl.contains(-396));
		assertTrue(avl.contains(-456));
		assertTrue(avl.contains(-86));
		assertTrue(avl.contains(310));
		assertTrue(avl.contains(-229));
		assertTrue(avl.contains(428));
		assertTrue(avl.contains(449));
		assertTrue(avl.contains(-424));
		assertTrue(avl.contains(-48));
		assertTrue(avl.contains(347));
		assertTrue(avl.contains(-342));
		assertTrue(avl.contains(1));
		assertTrue(avl.contains(-118));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl16() {
		avl.add(40);
		avl.add(485);
		avl.add(-314);
		avl.add(-268);
		avl.add(-1);
		avl.add(322);
		avl.add(-290);
		avl.add(-360);
		avl.add(-318);
		avl.add(71);
		avl.add(-212);
		avl.add(-45);
		avl.add(-22);
		avl.add(209);

		assertTrue(avl.contains(40));
		assertTrue(avl.contains(485));
		assertTrue(avl.contains(-314));
		assertTrue(avl.contains(-268));
		assertTrue(avl.contains(-1));
		assertTrue(avl.contains(322));
		assertTrue(avl.contains(-290));
		assertTrue(avl.contains(-360));
		assertTrue(avl.contains(-318));
		assertTrue(avl.contains(71));
		assertTrue(avl.contains(-212));
		assertTrue(avl.contains(-45));
		assertTrue(avl.contains(-22));
		assertTrue(avl.contains(209));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl17() {
		avl.add(-372);
		avl.add(196);
		avl.add(-37);
		avl.add(-324);
		avl.add(268);
		avl.add(-243);
		avl.add(202);
		avl.add(-309);
		avl.add(325);
		avl.add(414);
		avl.add(52);
		avl.add(375);
		avl.add(82);
		avl.add(-456);

		assertTrue(avl.contains(-372));
		assertTrue(avl.contains(196));
		assertTrue(avl.contains(-37));
		assertTrue(avl.contains(-324));
		assertTrue(avl.contains(268));
		assertTrue(avl.contains(-243));
		assertTrue(avl.contains(202));
		assertTrue(avl.contains(-309));
		assertTrue(avl.contains(325));
		assertTrue(avl.contains(414));
		assertTrue(avl.contains(52));
		assertTrue(avl.contains(375));
		assertTrue(avl.contains(82));
		assertTrue(avl.contains(-456));
		assertEquals(14, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl18() {
		avl.add(304);
		avl.add(-275);
		avl.add(-214);
		avl.add(-180);
		avl.add(-342);
		avl.add(-363);
		avl.add(92);
		avl.add(45);
		avl.add(395);
		avl.add(-7);
		avl.add(-260);

		assertTrue(avl.contains(304));
		assertTrue(avl.contains(-275));
		assertTrue(avl.contains(-214));
		assertTrue(avl.contains(-180));
		assertTrue(avl.contains(-342));
		assertTrue(avl.contains(-363));
		assertTrue(avl.contains(92));
		assertTrue(avl.contains(45));
		assertTrue(avl.contains(395));
		assertTrue(avl.contains(-7));
		assertTrue(avl.contains(-260));
		assertEquals(11, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl19() {
		avl.add(-125);
		avl.add(-150);
		avl.add(-377);
		avl.add(-274);
		avl.add(-252);
		avl.add(466);
		avl.add(164);
		avl.add(44);
		avl.add(161);
		avl.add(12);
		avl.add(-355);
		avl.add(-251);

		assertTrue(avl.contains(-125));
		assertTrue(avl.contains(-150));
		assertTrue(avl.contains(-377));
		assertTrue(avl.contains(-274));
		assertTrue(avl.contains(-252));
		assertTrue(avl.contains(466));
		assertTrue(avl.contains(164));
		assertTrue(avl.contains(44));
		assertTrue(avl.contains(161));
		assertTrue(avl.contains(12));
		assertTrue(avl.contains(-355));
		assertTrue(avl.contains(-251));
		assertEquals(12, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addTestavl20() {
		avl.add(-300);
		avl.add(76);
		avl.add(221);
		avl.add(401);
		avl.add(-398);
		avl.add(-277);
		avl.add(243);
		avl.add(208);
		avl.add(-307);
		avl.add(204);
		avl.add(392);
		avl.add(-274);
		avl.add(-360);

		assertTrue(avl.contains(-300));
		assertTrue(avl.contains(76));
		assertTrue(avl.contains(221));
		assertTrue(avl.contains(401));
		assertTrue(avl.contains(-398));
		assertTrue(avl.contains(-277));
		assertTrue(avl.contains(243));
		assertTrue(avl.contains(208));
		assertTrue(avl.contains(-307));
		assertTrue(avl.contains(204));
		assertTrue(avl.contains(392));
		assertTrue(avl.contains(-274));
		assertTrue(avl.contains(-360));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst1() {
		bst.add(-22);
		bst.add(-7);
		bst.add(-489);
		bst.add(348);
		bst.add(222);
		bst.add(-242);
		bst.add(236);
		bst.add(446);
		bst.add(21);
		bst.add(289);
		bst.add(-169);
		bst.add(-96);
		bst.add(-18);
		bst.remove(21);
		bst.remove(222);

		assertTrue(bst.contains(-22));
		assertTrue(bst.contains(-7));
		assertTrue(bst.contains(-489));
		assertTrue(bst.contains(348));
		assertTrue(bst.contains(-242));
		assertTrue(bst.contains(236));
		assertTrue(bst.contains(446));
		assertTrue(bst.contains(289));
		assertTrue(bst.contains(-169));
		assertTrue(bst.contains(-96));
		assertTrue(bst.contains(-18));
		assertFalse(bst.contains(21));
		assertFalse(bst.contains(222));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst2() {
		bst.add(101);
		bst.add(112);
		bst.add(-116);
		bst.add(-416);
		bst.add(17);
		bst.add(-209);
		bst.add(-496);
		bst.add(-104);
		bst.add(492);
		bst.add(245);
		bst.add(-224);
		bst.add(0);
		bst.add(93);
		bst.add(277);
		bst.add(165);
		bst.remove(-104);
		bst.remove(17);
		bst.remove(-209);

		assertTrue(bst.contains(101));
		assertTrue(bst.contains(112));
		assertTrue(bst.contains(-116));
		assertTrue(bst.contains(-416));
		assertTrue(bst.contains(-496));
		assertTrue(bst.contains(492));
		assertTrue(bst.contains(245));
		assertTrue(bst.contains(-224));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(93));
		assertTrue(bst.contains(277));
		assertTrue(bst.contains(165));
		assertFalse(bst.contains(-104));
		assertFalse(bst.contains(17));
		assertFalse(bst.contains(-209));
		assertEquals(12, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst3() {
		bst.add(-414);
		bst.add(252);
		bst.add(470);
		bst.add(453);
		bst.add(-33);
		bst.add(-117);
		bst.add(45);
		bst.add(216);
		bst.add(238);
		bst.add(333);
		bst.add(-168);
		bst.add(-135);
		bst.remove(45);
		bst.remove(-168);

		assertTrue(bst.contains(-414));
		assertTrue(bst.contains(252));
		assertTrue(bst.contains(470));
		assertTrue(bst.contains(453));
		assertTrue(bst.contains(-33));
		assertTrue(bst.contains(-117));
		assertTrue(bst.contains(216));
		assertTrue(bst.contains(238));
		assertTrue(bst.contains(333));
		assertTrue(bst.contains(-135));
		assertFalse(bst.contains(45));
		assertFalse(bst.contains(-168));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst4() {
		bst.add(-69);
		bst.add(133);
		bst.add(-418);
		bst.add(263);
		bst.add(-93);
		bst.add(-37);
		bst.add(-355);
		bst.add(-169);
		bst.add(74);
		bst.add(487);
		bst.add(-357);
		bst.add(-224);
		bst.add(-59);
		bst.add(-359);
		bst.add(-450);
		bst.remove(133);
		bst.remove(74);
		bst.remove(-224);
		bst.remove(487);
		bst.remove(-359);

		assertTrue(bst.contains(-69));
		assertTrue(bst.contains(-418));
		assertTrue(bst.contains(263));
		assertTrue(bst.contains(-93));
		assertTrue(bst.contains(-37));
		assertTrue(bst.contains(-355));
		assertTrue(bst.contains(-169));
		assertTrue(bst.contains(-357));
		assertTrue(bst.contains(-59));
		assertTrue(bst.contains(-450));
		assertFalse(bst.contains(133));
		assertFalse(bst.contains(74));
		assertFalse(bst.contains(-224));
		assertFalse(bst.contains(487));
		assertFalse(bst.contains(-359));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst5() {
		bst.add(-386);
		bst.add(-26);
		bst.add(-58);
		bst.add(154);
		bst.add(-445);
		bst.add(11);
		bst.add(-460);
		bst.add(-259);
		bst.add(-99);
		bst.add(-23);
		bst.add(337);
		bst.remove(11);
		bst.remove(-26);
		bst.remove(337);
		bst.remove(-99);
		bst.remove(-23);

		assertTrue(bst.contains(-386));
		assertTrue(bst.contains(-58));
		assertTrue(bst.contains(154));
		assertTrue(bst.contains(-445));
		assertTrue(bst.contains(-460));
		assertTrue(bst.contains(-259));
		assertFalse(bst.contains(11));
		assertFalse(bst.contains(-26));
		assertFalse(bst.contains(337));
		assertFalse(bst.contains(-99));
		assertFalse(bst.contains(-23));
		assertEquals(6, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst6() {
		bst.add(130);
		bst.add(-71);
		bst.add(302);
		bst.add(-180);
		bst.add(-472);
		bst.add(-407);
		bst.add(-382);
		bst.add(-204);
		bst.add(250);
		bst.add(-395);
		bst.remove(-180);
		bst.remove(-204);
		bst.remove(-71);
		bst.remove(-395);

		assertTrue(bst.contains(130));
		assertTrue(bst.contains(302));
		assertTrue(bst.contains(-472));
		assertTrue(bst.contains(-407));
		assertTrue(bst.contains(-382));
		assertTrue(bst.contains(250));
		assertFalse(bst.contains(-180));
		assertFalse(bst.contains(-204));
		assertFalse(bst.contains(-71));
		assertFalse(bst.contains(-395));
		assertEquals(6, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst7() {
		bst.add(-68);
		bst.add(-229);
		bst.add(381);
		bst.add(-239);
		bst.add(-245);
		bst.add(-418);
		bst.add(382);
		bst.add(217);
		bst.add(336);
		bst.add(374);
		bst.add(-500);
		bst.add(-346);
		bst.add(-266);
		bst.add(414);
		bst.remove(-346);
		bst.remove(336);
		bst.remove(-239);
		bst.remove(-500);

		assertTrue(bst.contains(-68));
		assertTrue(bst.contains(-229));
		assertTrue(bst.contains(381));
		assertTrue(bst.contains(-245));
		assertTrue(bst.contains(-418));
		assertTrue(bst.contains(382));
		assertTrue(bst.contains(217));
		assertTrue(bst.contains(374));
		assertTrue(bst.contains(-266));
		assertTrue(bst.contains(414));
		assertFalse(bst.contains(-346));
		assertFalse(bst.contains(336));
		assertFalse(bst.contains(-239));
		assertFalse(bst.contains(-500));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst8() {
		bst.add(343);
		bst.add(-487);
		bst.add(-110);
		bst.add(264);
		bst.add(-347);
		bst.add(-219);
		bst.add(36);
		bst.add(-325);
		bst.add(-376);
		bst.add(-46);
		bst.remove(343);
		bst.remove(-347);

		assertTrue(bst.contains(-487));
		assertTrue(bst.contains(-110));
		assertTrue(bst.contains(264));
		assertTrue(bst.contains(-219));
		assertTrue(bst.contains(36));
		assertTrue(bst.contains(-325));
		assertTrue(bst.contains(-376));
		assertTrue(bst.contains(-46));
		assertFalse(bst.contains(343));
		assertFalse(bst.contains(-347));
		assertEquals(8, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst9() {
		bst.add(465);
		bst.add(186);
		bst.add(-144);
		bst.add(-326);
		bst.add(-394);
		bst.add(231);
		bst.add(-87);
		bst.add(-197);
		bst.add(215);
		bst.add(147);
		bst.add(-27);
		bst.add(199);
		bst.add(145);
		bst.add(-430);
		bst.add(-292);
		bst.remove(186);
		bst.remove(-27);
		bst.remove(465);
		bst.remove(145);

		assertTrue(bst.contains(-144));
		assertTrue(bst.contains(-326));
		assertTrue(bst.contains(-394));
		assertTrue(bst.contains(231));
		assertTrue(bst.contains(-87));
		assertTrue(bst.contains(-197));
		assertTrue(bst.contains(215));
		assertTrue(bst.contains(147));
		assertTrue(bst.contains(199));
		assertTrue(bst.contains(-430));
		assertTrue(bst.contains(-292));
		assertFalse(bst.contains(186));
		assertFalse(bst.contains(-27));
		assertFalse(bst.contains(465));
		assertFalse(bst.contains(145));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst10() {
		bst.add(181);
		bst.add(-324);
		bst.add(-106);
		bst.add(71);
		bst.add(386);
		bst.add(301);
		bst.add(-225);
		bst.add(43);
		bst.add(475);
		bst.add(59);
		bst.add(345);
		bst.add(-293);
		bst.remove(301);
		bst.remove(345);

		assertTrue(bst.contains(181));
		assertTrue(bst.contains(-324));
		assertTrue(bst.contains(-106));
		assertTrue(bst.contains(71));
		assertTrue(bst.contains(386));
		assertTrue(bst.contains(-225));
		assertTrue(bst.contains(43));
		assertTrue(bst.contains(475));
		assertTrue(bst.contains(59));
		assertTrue(bst.contains(-293));
		assertFalse(bst.contains(301));
		assertFalse(bst.contains(345));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst11() {
		bst.add(330);
		bst.add(231);
		bst.add(-273);
		bst.add(-297);
		bst.add(280);
		bst.add(76);
		bst.add(-272);
		bst.add(-201);
		bst.add(-233);
		bst.add(189);
		bst.add(-227);
		bst.add(323);
		bst.add(-84);
		bst.add(-388);
		bst.remove(-233);
		bst.remove(-297);
		bst.remove(-201);
		bst.remove(330);

		assertTrue(bst.contains(231));
		assertTrue(bst.contains(-273));
		assertTrue(bst.contains(280));
		assertTrue(bst.contains(76));
		assertTrue(bst.contains(-272));
		assertTrue(bst.contains(189));
		assertTrue(bst.contains(-227));
		assertTrue(bst.contains(323));
		assertTrue(bst.contains(-84));
		assertTrue(bst.contains(-388));
		assertFalse(bst.contains(-233));
		assertFalse(bst.contains(-297));
		assertFalse(bst.contains(-201));
		assertFalse(bst.contains(330));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst12() {
		bst.add(485);
		bst.add(-429);
		bst.add(-112);
		bst.add(375);
		bst.add(301);
		bst.add(79);
		bst.add(-473);
		bst.add(252);
		bst.add(-31);
		bst.add(270);
		bst.add(-228);
		bst.add(372);
		bst.add(215);
		bst.add(34);
		bst.remove(-473);
		bst.remove(-228);
		bst.remove(79);

		assertTrue(bst.contains(485));
		assertTrue(bst.contains(-429));
		assertTrue(bst.contains(-112));
		assertTrue(bst.contains(375));
		assertTrue(bst.contains(301));
		assertTrue(bst.contains(252));
		assertTrue(bst.contains(-31));
		assertTrue(bst.contains(270));
		assertTrue(bst.contains(372));
		assertTrue(bst.contains(215));
		assertTrue(bst.contains(34));
		assertFalse(bst.contains(-473));
		assertFalse(bst.contains(-228));
		assertFalse(bst.contains(79));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst13() {
		bst.add(110);
		bst.add(107);
		bst.add(-145);
		bst.add(2);
		bst.add(92);
		bst.add(-438);
		bst.add(483);
		bst.add(96);
		bst.add(-335);
		bst.add(158);
		bst.add(72);
		bst.add(-146);
		bst.add(164);
		bst.remove(2);
		bst.remove(-438);
		bst.remove(110);
		bst.remove(72);
		bst.remove(-146);

		assertTrue(bst.contains(107));
		assertTrue(bst.contains(-145));
		assertTrue(bst.contains(92));
		assertTrue(bst.contains(483));
		assertTrue(bst.contains(96));
		assertTrue(bst.contains(-335));
		assertTrue(bst.contains(158));
		assertTrue(bst.contains(164));
		assertFalse(bst.contains(2));
		assertFalse(bst.contains(-438));
		assertFalse(bst.contains(110));
		assertFalse(bst.contains(72));
		assertFalse(bst.contains(-146));
		assertEquals(8, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst14() {
		bst.add(-246);
		bst.add(66);
		bst.add(-289);
		bst.add(-232);
		bst.add(-391);
		bst.add(374);
		bst.add(-312);
		bst.add(305);
		bst.add(191);
		bst.add(-260);
		bst.add(-24);
		bst.add(-412);
		bst.add(-402);
		bst.add(291);
		bst.add(41);
		bst.remove(-312);
		bst.remove(-246);
		bst.remove(-289);
		bst.remove(191);

		assertTrue(bst.contains(66));
		assertTrue(bst.contains(-232));
		assertTrue(bst.contains(-391));
		assertTrue(bst.contains(374));
		assertTrue(bst.contains(305));
		assertTrue(bst.contains(-260));
		assertTrue(bst.contains(-24));
		assertTrue(bst.contains(-412));
		assertTrue(bst.contains(-402));
		assertTrue(bst.contains(291));
		assertTrue(bst.contains(41));
		assertFalse(bst.contains(-312));
		assertFalse(bst.contains(-246));
		assertFalse(bst.contains(-289));
		assertFalse(bst.contains(191));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst15() {
		bst.add(-381);
		bst.add(-237);
		bst.add(300);
		bst.add(-246);
		bst.add(-181);
		bst.add(406);
		bst.add(383);
		bst.add(292);
		bst.add(291);
		bst.add(-440);
		bst.add(-443);
		bst.add(426);
		bst.add(-15);
		bst.remove(-246);
		bst.remove(426);
		bst.remove(-181);

		assertTrue(bst.contains(-381));
		assertTrue(bst.contains(-237));
		assertTrue(bst.contains(300));
		assertTrue(bst.contains(406));
		assertTrue(bst.contains(383));
		assertTrue(bst.contains(292));
		assertTrue(bst.contains(291));
		assertTrue(bst.contains(-440));
		assertTrue(bst.contains(-443));
		assertTrue(bst.contains(-15));
		assertFalse(bst.contains(-246));
		assertFalse(bst.contains(426));
		assertFalse(bst.contains(-181));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst16() {
		bst.add(3);
		bst.add(461);
		bst.add(-355);
		bst.add(-218);
		bst.add(34);
		bst.add(214);
		bst.add(-49);
		bst.add(-322);
		bst.add(470);
		bst.add(147);
		bst.add(-140);
		bst.add(155);
		bst.remove(147);
		bst.remove(-218);
		bst.remove(214);
		bst.remove(-49);

		assertTrue(bst.contains(3));
		assertTrue(bst.contains(461));
		assertTrue(bst.contains(-355));
		assertTrue(bst.contains(34));
		assertTrue(bst.contains(-322));
		assertTrue(bst.contains(470));
		assertTrue(bst.contains(-140));
		assertTrue(bst.contains(155));
		assertFalse(bst.contains(147));
		assertFalse(bst.contains(-218));
		assertFalse(bst.contains(214));
		assertFalse(bst.contains(-49));
		assertEquals(8, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst17() {
		bst.add(348);
		bst.add(-262);
		bst.add(20);
		bst.add(111);
		bst.add(430);
		bst.add(232);
		bst.add(-16);
		bst.add(226);
		bst.add(76);
		bst.add(-68);
		bst.add(-176);
		bst.remove(111);
		bst.remove(-68);

		assertTrue(bst.contains(348));
		assertTrue(bst.contains(-262));
		assertTrue(bst.contains(20));
		assertTrue(bst.contains(430));
		assertTrue(bst.contains(232));
		assertTrue(bst.contains(-16));
		assertTrue(bst.contains(226));
		assertTrue(bst.contains(76));
		assertTrue(bst.contains(-176));
		assertFalse(bst.contains(111));
		assertFalse(bst.contains(-68));
		assertEquals(9, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst18() {
		bst.add(181);
		bst.add(119);
		bst.add(-23);
		bst.add(-373);
		bst.add(-101);
		bst.add(191);
		bst.add(74);
		bst.add(-3);
		bst.add(249);
		bst.add(57);
		bst.add(455);
		bst.add(-116);
		bst.remove(249);
		bst.remove(-101);
		bst.remove(-116);

		assertTrue(bst.contains(181));
		assertTrue(bst.contains(119));
		assertTrue(bst.contains(-23));
		assertTrue(bst.contains(-373));
		assertTrue(bst.contains(191));
		assertTrue(bst.contains(74));
		assertTrue(bst.contains(-3));
		assertTrue(bst.contains(57));
		assertTrue(bst.contains(455));
		assertFalse(bst.contains(249));
		assertFalse(bst.contains(-101));
		assertFalse(bst.contains(-116));
		assertEquals(9, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst19() {
		bst.add(-197);
		bst.add(-19);
		bst.add(419);
		bst.add(485);
		bst.add(173);
		bst.add(-279);
		bst.add(-402);
		bst.add(20);
		bst.add(97);
		bst.add(397);
		bst.add(311);
		bst.add(437);
		bst.add(285);
		bst.add(177);
		bst.remove(20);
		bst.remove(485);
		bst.remove(-197);
		bst.remove(177);

		assertTrue(bst.contains(-19));
		assertTrue(bst.contains(419));
		assertTrue(bst.contains(173));
		assertTrue(bst.contains(-279));
		assertTrue(bst.contains(-402));
		assertTrue(bst.contains(97));
		assertTrue(bst.contains(397));
		assertTrue(bst.contains(311));
		assertTrue(bst.contains(437));
		assertTrue(bst.contains(285));
		assertFalse(bst.contains(20));
		assertFalse(bst.contains(485));
		assertFalse(bst.contains(-197));
		assertFalse(bst.contains(177));
		assertEquals(10, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestbst20() {
		bst.add(-116);
		bst.add(-376);
		bst.add(-170);
		bst.add(-279);
		bst.add(-346);
		bst.add(-332);
		bst.add(204);
		bst.add(160);
		bst.add(107);
		bst.add(-250);
		bst.add(56);
		bst.add(69);
		bst.add(477);
		bst.add(189);
		bst.remove(69);
		bst.remove(107);
		bst.remove(-376);

		assertTrue(bst.contains(-116));
		assertTrue(bst.contains(-170));
		assertTrue(bst.contains(-279));
		assertTrue(bst.contains(-346));
		assertTrue(bst.contains(-332));
		assertTrue(bst.contains(204));
		assertTrue(bst.contains(160));
		assertTrue(bst.contains(-250));
		assertTrue(bst.contains(56));
		assertTrue(bst.contains(477));
		assertTrue(bst.contains(189));
		assertFalse(bst.contains(69));
		assertFalse(bst.contains(107));
		assertFalse(bst.contains(-376));
		assertEquals(11, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl1() {
		avl.add(257);
		avl.add(-333);
		avl.add(-461);
		avl.add(-35);
		avl.add(-290);
		avl.add(212);
		avl.add(-201);
		avl.add(-368);
		avl.add(113);
		avl.add(80);
		avl.add(35);
		avl.remove(-290);
		avl.remove(113);
		avl.remove(35);
		avl.remove(257);

		assertTrue(avl.contains(-333));
		assertTrue(avl.contains(-461));
		assertTrue(avl.contains(-35));
		assertTrue(avl.contains(212));
		assertTrue(avl.contains(-201));
		assertTrue(avl.contains(-368));
		assertTrue(avl.contains(80));
		assertFalse(avl.contains(-290));
		assertFalse(avl.contains(113));
		assertFalse(avl.contains(35));
		assertFalse(avl.contains(257));
		assertEquals(7, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl2() {
		avl.add(-129);
		avl.add(207);
		avl.add(-164);
		avl.add(-88);
		avl.add(-340);
		avl.add(-472);
		avl.add(90);
		avl.add(-30);
		avl.add(49);
		avl.add(245);
		avl.add(-186);
		avl.add(329);
		avl.add(-405);
		avl.add(-434);
		avl.remove(-472);
		avl.remove(49);
		avl.remove(-186);
		avl.remove(-88);
		avl.remove(-30);

		assertTrue(avl.contains(-129));
		assertTrue(avl.contains(207));
		assertTrue(avl.contains(-164));
		assertTrue(avl.contains(-340));
		assertTrue(avl.contains(90));
		assertTrue(avl.contains(245));
		assertTrue(avl.contains(329));
		assertTrue(avl.contains(-405));
		assertTrue(avl.contains(-434));
		assertFalse(avl.contains(-472));
		assertFalse(avl.contains(49));
		assertFalse(avl.contains(-186));
		assertFalse(avl.contains(-88));
		assertFalse(avl.contains(-30));
		assertEquals(9, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl3() {
		avl.add(141);
		avl.add(-121);
		avl.add(425);
		avl.add(362);
		avl.add(431);
		avl.add(-439);
		avl.add(-139);
		avl.add(-227);
		avl.add(-59);
		avl.add(-325);
		avl.remove(362);
		avl.remove(-139);
		avl.remove(-59);

		assertTrue(avl.contains(141));
		assertTrue(avl.contains(-121));
		assertTrue(avl.contains(425));
		assertTrue(avl.contains(431));
		assertTrue(avl.contains(-439));
		assertTrue(avl.contains(-227));
		assertTrue(avl.contains(-325));
		assertFalse(avl.contains(362));
		assertFalse(avl.contains(-139));
		assertFalse(avl.contains(-59));
		assertEquals(7, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl4() {
		avl.add(-219);
		avl.add(-189);
		avl.add(-182);
		avl.add(-90);
		avl.add(-45);
		avl.add(-269);
		avl.add(183);
		avl.add(305);
		avl.add(443);
		avl.add(399);
		avl.add(0);
		avl.remove(305);
		avl.remove(0);
		avl.remove(443);
		avl.remove(-45);
		avl.remove(-219);

		assertTrue(avl.contains(-189));
		assertTrue(avl.contains(-182));
		assertTrue(avl.contains(-90));
		assertTrue(avl.contains(-269));
		assertTrue(avl.contains(183));
		assertTrue(avl.contains(399));
		assertFalse(avl.contains(305));
		assertFalse(avl.contains(0));
		assertFalse(avl.contains(443));
		assertFalse(avl.contains(-45));
		assertFalse(avl.contains(-219));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl5() {
		avl.add(456);
		avl.add(354);
		avl.add(146);
		avl.add(388);
		avl.add(329);
		avl.add(380);
		avl.add(479);
		avl.add(115);
		avl.add(-216);
		avl.add(-350);
		avl.add(402);
		avl.remove(-350);
		avl.remove(-216);
		avl.remove(388);
		avl.remove(329);
		avl.remove(115);

		assertTrue(avl.contains(456));
		assertTrue(avl.contains(354));
		assertTrue(avl.contains(146));
		assertTrue(avl.contains(380));
		assertTrue(avl.contains(479));
		assertTrue(avl.contains(402));
		assertFalse(avl.contains(-350));
		assertFalse(avl.contains(-216));
		assertFalse(avl.contains(388));
		assertFalse(avl.contains(329));
		assertFalse(avl.contains(115));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl6() {
		avl.add(-216);
		avl.add(240);
		avl.add(68);
		avl.add(76);
		avl.add(258);
		avl.add(55);
		avl.add(171);
		avl.add(372);
		avl.add(15);
		avl.add(150);
		avl.add(-214);
		avl.remove(372);
		avl.remove(-214);

		assertTrue(avl.contains(-216));
		assertTrue(avl.contains(240));
		assertTrue(avl.contains(68));
		assertTrue(avl.contains(76));
		assertTrue(avl.contains(258));
		assertTrue(avl.contains(55));
		assertTrue(avl.contains(171));
		assertTrue(avl.contains(15));
		assertTrue(avl.contains(150));
		assertFalse(avl.contains(372));
		assertFalse(avl.contains(-214));
		assertEquals(9, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl7() {
		avl.add(414);
		avl.add(89);
		avl.add(-203);
		avl.add(32);
		avl.add(-160);
		avl.add(443);
		avl.add(-289);
		avl.add(-350);
		avl.add(-407);
		avl.add(19);
		avl.remove(414);
		avl.remove(89);

		assertTrue(avl.contains(-203));
		assertTrue(avl.contains(32));
		assertTrue(avl.contains(-160));
		assertTrue(avl.contains(443));
		assertTrue(avl.contains(-289));
		assertTrue(avl.contains(-350));
		assertTrue(avl.contains(-407));
		assertTrue(avl.contains(19));
		assertFalse(avl.contains(414));
		assertFalse(avl.contains(89));
		assertEquals(8, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl8() {
		avl.add(276);
		avl.add(-104);
		avl.add(142);
		avl.add(-92);
		avl.add(-464);
		avl.add(-327);
		avl.add(348);
		avl.add(370);
		avl.add(-125);
		avl.add(-169);
		avl.add(-443);
		avl.add(61);
		avl.add(-338);
		avl.add(22);
		avl.add(-380);
		avl.remove(-169);
		avl.remove(22);
		avl.remove(276);
		avl.remove(142);
		avl.remove(-338);

		assertTrue(avl.contains(-104));
		assertTrue(avl.contains(-92));
		assertTrue(avl.contains(-464));
		assertTrue(avl.contains(-327));
		assertTrue(avl.contains(348));
		assertTrue(avl.contains(370));
		assertTrue(avl.contains(-125));
		assertTrue(avl.contains(-443));
		assertTrue(avl.contains(61));
		assertTrue(avl.contains(-380));
		assertFalse(avl.contains(-169));
		assertFalse(avl.contains(22));
		assertFalse(avl.contains(276));
		assertFalse(avl.contains(142));
		assertFalse(avl.contains(-338));
		assertEquals(10, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl9() {
		avl.add(-177);
		avl.add(-318);
		avl.add(265);
		avl.add(-374);
		avl.add(-121);
		avl.add(408);
		avl.add(496);
		avl.add(75);
		avl.add(494);
		avl.add(-238);
		avl.add(64);
		avl.add(-114);
		avl.add(152);
		avl.add(-492);
		avl.add(-100);
		avl.remove(496);
		avl.remove(-492);
		avl.remove(-374);
		avl.remove(-121);
		avl.remove(-177);

		assertTrue(avl.contains(-318));
		assertTrue(avl.contains(265));
		assertTrue(avl.contains(408));
		assertTrue(avl.contains(75));
		assertTrue(avl.contains(494));
		assertTrue(avl.contains(-238));
		assertTrue(avl.contains(64));
		assertTrue(avl.contains(-114));
		assertTrue(avl.contains(152));
		assertTrue(avl.contains(-100));
		assertFalse(avl.contains(496));
		assertFalse(avl.contains(-492));
		assertFalse(avl.contains(-374));
		assertFalse(avl.contains(-121));
		assertFalse(avl.contains(-177));
		assertEquals(10, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl10() {
		avl.add(402);
		avl.add(121);
		avl.add(126);
		avl.add(-274);
		avl.add(170);
		avl.add(-151);
		avl.add(295);
		avl.add(-104);
		avl.add(-39);
		avl.add(-258);
		avl.add(44);
		avl.add(355);
		avl.add(-6);
		avl.add(373);
		avl.add(-190);
		avl.remove(295);
		avl.remove(-190);

		assertTrue(avl.contains(402));
		assertTrue(avl.contains(121));
		assertTrue(avl.contains(126));
		assertTrue(avl.contains(-274));
		assertTrue(avl.contains(170));
		assertTrue(avl.contains(-151));
		assertTrue(avl.contains(-104));
		assertTrue(avl.contains(-39));
		assertTrue(avl.contains(-258));
		assertTrue(avl.contains(44));
		assertTrue(avl.contains(355));
		assertTrue(avl.contains(-6));
		assertTrue(avl.contains(373));
		assertFalse(avl.contains(295));
		assertFalse(avl.contains(-190));
		assertEquals(13, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl11() {
		avl.add(406);
		avl.add(304);
		avl.add(95);
		avl.add(-286);
		avl.add(171);
		avl.add(213);
		avl.add(-406);
		avl.add(-54);
		avl.add(336);
		avl.add(236);
		avl.add(-454);
		avl.remove(95);
		avl.remove(406);
		avl.remove(-454);
		avl.remove(236);
		avl.remove(-406);

		assertTrue(avl.contains(304));
		assertTrue(avl.contains(-286));
		assertTrue(avl.contains(171));
		assertTrue(avl.contains(213));
		assertTrue(avl.contains(-54));
		assertTrue(avl.contains(336));
		assertFalse(avl.contains(95));
		assertFalse(avl.contains(406));
		assertFalse(avl.contains(-454));
		assertFalse(avl.contains(236));
		assertFalse(avl.contains(-406));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl12() {
		avl.add(-352);
		avl.add(296);
		avl.add(-163);
		avl.add(449);
		avl.add(-274);
		avl.add(78);
		avl.add(-230);
		avl.add(375);
		avl.add(-447);
		avl.add(-495);
		avl.add(83);
		avl.remove(-230);
		avl.remove(-163);
		avl.remove(-447);
		avl.remove(375);
		avl.remove(-495);

		assertTrue(avl.contains(-352));
		assertTrue(avl.contains(296));
		assertTrue(avl.contains(449));
		assertTrue(avl.contains(-274));
		assertTrue(avl.contains(78));
		assertTrue(avl.contains(83));
		assertFalse(avl.contains(-230));
		assertFalse(avl.contains(-163));
		assertFalse(avl.contains(-447));
		assertFalse(avl.contains(375));
		assertFalse(avl.contains(-495));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl13() {
		avl.add(-442);
		avl.add(411);
		avl.add(392);
		avl.add(454);
		avl.add(144);
		avl.add(145);
		avl.add(-289);
		avl.add(468);
		avl.add(219);
		avl.add(141);
		avl.remove(144);
		avl.remove(-442);

		assertTrue(avl.contains(411));
		assertTrue(avl.contains(392));
		assertTrue(avl.contains(454));
		assertTrue(avl.contains(145));
		assertTrue(avl.contains(-289));
		assertTrue(avl.contains(468));
		assertTrue(avl.contains(219));
		assertTrue(avl.contains(141));
		assertFalse(avl.contains(144));
		assertFalse(avl.contains(-442));
		assertEquals(8, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl14() {
		avl.add(-448);
		avl.add(-163);
		avl.add(-237);
		avl.add(-386);
		avl.add(-345);
		avl.add(460);
		avl.add(33);
		avl.add(-367);
		avl.add(165);
		avl.add(-493);
		avl.add(118);
		avl.remove(-237);
		avl.remove(460);
		avl.remove(165);

		assertTrue(avl.contains(-448));
		assertTrue(avl.contains(-163));
		assertTrue(avl.contains(-386));
		assertTrue(avl.contains(-345));
		assertTrue(avl.contains(33));
		assertTrue(avl.contains(-367));
		assertTrue(avl.contains(-493));
		assertTrue(avl.contains(118));
		assertFalse(avl.contains(-237));
		assertFalse(avl.contains(460));
		assertFalse(avl.contains(165));
		assertEquals(8, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl15() {
		avl.add(-422);
		avl.add(48);
		avl.add(-101);
		avl.add(-278);
		avl.add(-338);
		avl.add(-121);
		avl.add(-271);
		avl.add(159);
		avl.add(482);
		avl.add(70);
		avl.remove(48);
		avl.remove(-121);
		avl.remove(-101);

		assertTrue(avl.contains(-422));
		assertTrue(avl.contains(-278));
		assertTrue(avl.contains(-338));
		assertTrue(avl.contains(-271));
		assertTrue(avl.contains(159));
		assertTrue(avl.contains(482));
		assertTrue(avl.contains(70));
		assertFalse(avl.contains(48));
		assertFalse(avl.contains(-121));
		assertFalse(avl.contains(-101));
		assertEquals(7, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl16() {
		avl.add(223);
		avl.add(-184);
		avl.add(-384);
		avl.add(-140);
		avl.add(-60);
		avl.add(-227);
		avl.add(470);
		avl.add(-7);
		avl.add(-294);
		avl.add(-200);
		avl.remove(223);
		avl.remove(-184);
		avl.remove(-7);
		avl.remove(470);

		assertTrue(avl.contains(-384));
		assertTrue(avl.contains(-140));
		assertTrue(avl.contains(-60));
		assertTrue(avl.contains(-227));
		assertTrue(avl.contains(-294));
		assertTrue(avl.contains(-200));
		assertFalse(avl.contains(223));
		assertFalse(avl.contains(-184));
		assertFalse(avl.contains(-7));
		assertFalse(avl.contains(470));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl17() {
		avl.add(-95);
		avl.add(-428);
		avl.add(-139);
		avl.add(141);
		avl.add(-461);
		avl.add(-140);
		avl.add(-3);
		avl.add(383);
		avl.add(-339);
		avl.add(-114);
		avl.remove(-95);
		avl.remove(383);
		avl.remove(-114);

		assertTrue(avl.contains(-428));
		assertTrue(avl.contains(-139));
		assertTrue(avl.contains(141));
		assertTrue(avl.contains(-461));
		assertTrue(avl.contains(-140));
		assertTrue(avl.contains(-3));
		assertTrue(avl.contains(-339));
		assertFalse(avl.contains(-95));
		assertFalse(avl.contains(383));
		assertFalse(avl.contains(-114));
		assertEquals(7, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl18() {
		avl.add(-211);
		avl.add(-370);
		avl.add(480);
		avl.add(-365);
		avl.add(-184);
		avl.add(367);
		avl.add(58);
		avl.add(439);
		avl.add(-54);
		avl.add(-270);
		avl.remove(367);
		avl.remove(58);
		avl.remove(-270);
		avl.remove(-184);
		avl.remove(-211);

		assertTrue(avl.contains(-370));
		assertTrue(avl.contains(480));
		assertTrue(avl.contains(-365));
		assertTrue(avl.contains(439));
		assertTrue(avl.contains(-54));
		assertFalse(avl.contains(367));
		assertFalse(avl.contains(58));
		assertFalse(avl.contains(-270));
		assertFalse(avl.contains(-184));
		assertFalse(avl.contains(-211));
		assertEquals(5, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl19() {
		avl.add(394);
		avl.add(363);
		avl.add(290);
		avl.add(-29);
		avl.add(267);
		avl.add(118);
		avl.add(308);
		avl.add(470);
		avl.add(-335);
		avl.add(199);
		avl.remove(308);
		avl.remove(118);
		avl.remove(363);
		avl.remove(-29);

		assertTrue(avl.contains(394));
		assertTrue(avl.contains(290));
		assertTrue(avl.contains(267));
		assertTrue(avl.contains(470));
		assertTrue(avl.contains(-335));
		assertTrue(avl.contains(199));
		assertFalse(avl.contains(308));
		assertFalse(avl.contains(118));
		assertFalse(avl.contains(363));
		assertFalse(avl.contains(-29));
		assertEquals(6, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeTestavl20() {
		avl.add(-330);
		avl.add(-56);
		avl.add(18);
		avl.add(467);
		avl.add(429);
		avl.add(-496);
		avl.add(348);
		avl.add(443);
		avl.add(-286);
		avl.add(164);
		avl.remove(-330);
		avl.remove(-286);
		avl.remove(467);
		avl.remove(443);
		avl.remove(18);

		assertTrue(avl.contains(-56));
		assertTrue(avl.contains(429));
		assertTrue(avl.contains(-496));
		assertTrue(avl.contains(348));
		assertTrue(avl.contains(164));
		assertFalse(avl.contains(-330));
		assertFalse(avl.contains(-286));
		assertFalse(avl.contains(467));
		assertFalse(avl.contains(443));
		assertFalse(avl.contains(18));
		assertEquals(5, avl.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestbst1() {
		bst.add(405);
		bst.add(159);
		bst.add(-10);
		bst.add(214);
		bst.add(475);
		bst.add(81);
		bst.add(-43);
		bst.add(-493);
		bst.add(192);
		bst.add(0);
		bst.add(-161);

		assertEquals((Integer) (405), bst.get(405));
		assertEquals((Integer) (159), bst.get(159));
		assertEquals((Integer) (-10), bst.get(-10));
		assertEquals((Integer) (214), bst.get(214));
		assertEquals((Integer) (475), bst.get(475));
		assertEquals((Integer) (81), bst.get(81));
		assertEquals((Integer) (-43), bst.get(-43));
		assertEquals((Integer) (-493), bst.get(-493));
		assertEquals((Integer) (192), bst.get(192));
		assertEquals((Integer) (0), bst.get(0));
		assertEquals((Integer) (-161), bst.get(-161));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestbst2() {
		bst.add(-125);
		bst.add(43);
		bst.add(-350);
		bst.add(-170);
		bst.add(259);
		bst.add(473);
		bst.add(-181);
		bst.add(292);
		bst.add(-189);
		bst.add(-225);
		bst.add(187);
		bst.add(-148);

		assertEquals((Integer) (-125), bst.get(-125));
		assertEquals((Integer) (43), bst.get(43));
		assertEquals((Integer) (-350), bst.get(-350));
		assertEquals((Integer) (-170), bst.get(-170));
		assertEquals((Integer) (259), bst.get(259));
		assertEquals((Integer) (473), bst.get(473));
		assertEquals((Integer) (-181), bst.get(-181));
		assertEquals((Integer) (292), bst.get(292));
		assertEquals((Integer) (-189), bst.get(-189));
		assertEquals((Integer) (-225), bst.get(-225));
		assertEquals((Integer) (187), bst.get(187));
		assertEquals((Integer) (-148), bst.get(-148));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestbst3() {
		bst.add(140);
		bst.add(-202);
		bst.add(-351);
		bst.add(331);
		bst.add(29);
		bst.add(-488);
		bst.add(-34);
		bst.add(63);
		bst.add(-27);
		bst.add(-320);
		bst.add(-190);
		bst.add(308);
		bst.add(-176);

		assertEquals((Integer) (140), bst.get(140));
		assertEquals((Integer) (-202), bst.get(-202));
		assertEquals((Integer) (-351), bst.get(-351));
		assertEquals((Integer) (331), bst.get(331));
		assertEquals((Integer) (29), bst.get(29));
		assertEquals((Integer) (-488), bst.get(-488));
		assertEquals((Integer) (-34), bst.get(-34));
		assertEquals((Integer) (63), bst.get(63));
		assertEquals((Integer) (-27), bst.get(-27));
		assertEquals((Integer) (-320), bst.get(-320));
		assertEquals((Integer) (-190), bst.get(-190));
		assertEquals((Integer) (308), bst.get(308));
		assertEquals((Integer) (-176), bst.get(-176));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestbst4() {
		bst.add(-292);
		bst.add(386);
		bst.add(-321);
		bst.add(-210);
		bst.add(65);
		bst.add(-47);
		bst.add(380);
		bst.add(-339);
		bst.add(-400);
		bst.add(-337);
		bst.add(206);
		bst.add(-71);

		assertEquals((Integer) (-292), bst.get(-292));
		assertEquals((Integer) (386), bst.get(386));
		assertEquals((Integer) (-321), bst.get(-321));
		assertEquals((Integer) (-210), bst.get(-210));
		assertEquals((Integer) (65), bst.get(65));
		assertEquals((Integer) (-47), bst.get(-47));
		assertEquals((Integer) (-210), bst.get(-210));
		assertEquals((Integer) (380), bst.get(380));
		assertEquals((Integer) (-339), bst.get(-339));
		assertEquals((Integer) (-400), bst.get(-400));
		assertEquals((Integer) (-337), bst.get(-337));
		assertEquals((Integer) (206), bst.get(206));
		assertEquals((Integer) (-71), bst.get(-71));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestbst5() {
		bst.add(-291);
		bst.add(-178);
		bst.add(-137);
		bst.add(-344);
		bst.add(219);
		bst.add(-118);
		bst.add(-11);
		bst.add(200);
		bst.add(66);
		bst.add(-354);
		bst.add(8);
		bst.add(-72);
		bst.add(470);
		bst.add(-76);

		assertEquals((Integer) (-291), bst.get(-291));
		assertEquals((Integer) (-178), bst.get(-178));
		assertEquals((Integer) (-137), bst.get(-137));
		assertEquals((Integer) (-344), bst.get(-344));
		assertEquals((Integer) (219), bst.get(219));
		assertEquals((Integer) (-118), bst.get(-118));
		assertEquals((Integer) (-11), bst.get(-11));
		assertEquals((Integer) (200), bst.get(200));
		assertEquals((Integer) (66), bst.get(66));
		assertEquals((Integer) (-354), bst.get(-354));
		assertEquals((Integer) (8), bst.get(8));
		assertEquals((Integer) (-72), bst.get(-72));
		assertEquals((Integer) (470), bst.get(470));
		assertEquals((Integer) (-76), bst.get(-76));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestavl1() {
		avl.add(97);
		avl.add(39);
		avl.add(51);
		avl.add(-480);
		avl.add(-195);
		avl.add(162);
		avl.add(-333);
		avl.add(-426);
		avl.add(-435);
		avl.add(170);
		avl.add(-466);

		assertEquals((Integer) (97), avl.get(97));
		assertEquals((Integer) (39), avl.get(39));
		assertEquals((Integer) (51), avl.get(51));
		assertEquals((Integer) (-480), avl.get(-480));
		assertEquals((Integer) (-195), avl.get(-195));
		assertEquals((Integer) (162), avl.get(162));
		assertEquals((Integer) (-333), avl.get(-333));
		assertEquals((Integer) (-426), avl.get(-426));
		assertEquals((Integer) (-435), avl.get(-435));
		assertEquals((Integer) (170), avl.get(170));
		assertEquals((Integer) (-466), avl.get(-466));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestavl2() {
		avl.add(411);
		avl.add(306);
		avl.add(-409);
		avl.add(-18);
		avl.add(-333);
		avl.add(216);
		avl.add(-352);
		avl.add(-191);
		avl.add(493);
		avl.add(167);
		avl.add(-66);
		avl.add(483);
		avl.add(40);
		avl.add(418);
		avl.add(68);

		assertEquals((Integer) (411), avl.get(411));
		assertEquals((Integer) (306), avl.get(306));
		assertEquals((Integer) (-409), avl.get(-409));
		assertEquals((Integer) (-18), avl.get(-18));
		assertEquals((Integer) (-333), avl.get(-333));
		assertEquals((Integer) (216), avl.get(216));
		assertEquals((Integer) (-352), avl.get(-352));
		assertEquals((Integer) (-191), avl.get(-191));
		assertEquals((Integer) (493), avl.get(493));
		assertEquals((Integer) (167), avl.get(167));
		assertEquals((Integer) (-66), avl.get(-66));
		assertEquals((Integer) (483), avl.get(483));
		assertEquals((Integer) (40), avl.get(40));
		assertEquals((Integer) (418), avl.get(418));
		assertEquals((Integer) (68), avl.get(68));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestavl3() {
		avl.add(-127);
		avl.add(-119);
		avl.add(206);
		avl.add(485);
		avl.add(-328);
		avl.add(-99);
		avl.add(-109);
		avl.add(-223);
		avl.add(42);
		avl.add(-45);
		avl.add(64);
		avl.add(425);
		avl.add(-278);
		avl.add(470);
		avl.add(184);

		assertEquals((Integer) (-127), avl.get(-127));
		assertEquals((Integer) (-119), avl.get(-119));
		assertEquals((Integer) (206), avl.get(206));
		assertEquals((Integer) (485), avl.get(485));
		assertEquals((Integer) (-328), avl.get(-328));
		assertEquals((Integer) (-99), avl.get(-99));
		assertEquals((Integer) (-109), avl.get(-109));
		assertEquals((Integer) (-223), avl.get(-223));
		assertEquals((Integer) (42), avl.get(42));
		assertEquals((Integer) (-45), avl.get(-45));
		assertEquals((Integer) (64), avl.get(64));
		assertEquals((Integer) (425), avl.get(425));
		assertEquals((Integer) (-278), avl.get(-278));
		assertEquals((Integer) (470), avl.get(470));
		assertEquals((Integer) (184), avl.get(184));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestavl4() {
		avl.add(413);
		avl.add(-218);
		avl.add(-213);
		avl.add(-480);
		avl.add(155);
		avl.add(431);
		avl.add(93);
		avl.add(218);
		avl.add(312);
		avl.add(-167);
		avl.add(103);
		avl.add(369);

		assertEquals((Integer) (413), avl.get(413));
		assertEquals((Integer) (-218), avl.get(-218));
		assertEquals((Integer) (-213), avl.get(-213));
		assertEquals((Integer) (-480), avl.get(-480));
		assertEquals((Integer) (155), avl.get(155));
		assertEquals((Integer) (431), avl.get(431));
		assertEquals((Integer) (93), avl.get(93));
		assertEquals((Integer) (218), avl.get(218));
		assertEquals((Integer) (312), avl.get(312));
		assertEquals((Integer) (-167), avl.get(-167));
		assertEquals((Integer) (103), avl.get(103));
		assertEquals((Integer) (369), avl.get(369));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void getTestavl5() {
		avl.add(71);
		avl.add(238);
		avl.add(355);
		avl.add(-351);
		avl.add(423);
		avl.add(-205);
		avl.add(-42);
		avl.add(-121);
		avl.add(-370);
		avl.add(-131);
		avl.add(233);
		avl.add(-277);
		avl.add(214);
		avl.add(-315);
		avl.add(-61);

		assertEquals((Integer) (71), avl.get(71));
		assertEquals((Integer) (238), avl.get(238));
		assertEquals((Integer) (355), avl.get(355));
		assertEquals((Integer) (-351), avl.get(-351));
		assertEquals((Integer) (423), avl.get(423));
		assertEquals((Integer) (-205), avl.get(-205));
		assertEquals((Integer) (-42), avl.get(-42));
		assertEquals((Integer) (-121), avl.get(-121));
		assertEquals((Integer) (-370), avl.get(-370));
		assertEquals((Integer) (-131), avl.get(-131));
		assertEquals((Integer) (233), avl.get(233));
		assertEquals((Integer) (-277), avl.get(-277));
		assertEquals((Integer) (214), avl.get(214));
		assertEquals((Integer) (-315), avl.get(-315));
		assertEquals((Integer) (-61), avl.get(-61));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addAllTestbst() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(null);
		list.add(1000);
		list.add(2000);
		list.add(3000);
		list.add(1500);

		bst.addAll(list);

		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
		assertTrue(bst.contains(7));
		assertTrue(bst.contains(8));
		assertTrue(bst.contains(9));
		assertTrue(bst.contains(10));
		assertTrue(bst.contains(11));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(1000));
		assertTrue(bst.contains(2000));
		assertTrue(bst.contains(3000));
		assertTrue(bst.contains(1500));
		assertEquals(list.size(), bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void addAllTestavl() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(null);
		list.add(10);
		list.add(11);
		list.add(13);
		list.add(-19);
		list.add(-20);
		list.add(-21);
		list.add(12);
		list.add(123);

		avl.addAll(list);

		assertTrue(avl.contains(1));
		assertTrue(avl.contains(null));
		assertTrue(avl.contains(10));
		assertTrue(avl.contains(11));
		assertTrue(avl.contains(13));
		assertTrue(avl.contains(-19));
		assertTrue(avl.contains(-20));
		assertTrue(avl.contains(-21));
		assertTrue(avl.contains(12));
		assertTrue(avl.contains(123));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void preOrderTest1() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(10);
		t0.add(-5);
		t0.add(20);
		t0.add(30);
		t0.add(25);

		List<Integer> l0 = t0.preOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(10);
		l1.add(-5);
		l1.add(20);
		l1.add(30);
		l1.add(25);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void preOrderTest2() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(Integer.MAX_VALUE);
		t0.add(null);
		t0.add(Integer.MIN_VALUE);
		t0.add(10);
		t0.add(20);

		List<Integer> l0 = t0.preOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(Integer.MAX_VALUE);
		l1.add(Integer.MIN_VALUE);
		l1.add(10);
		l1.add(20);
		l1.add(null);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void inOrderTest1() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(1);
		t0.add(null);
		t0.add(2);
		t0.add(-99);
		t0.add(100);
		t0.add(20);

		List<Integer> l0 = t0.inOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-99);
		l1.add(1);
		l1.add(2);
		l1.add(20);
		l1.add(100);
		l1.add(null);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void inOrderTest2() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(Integer.MAX_VALUE);
		t0.add(Integer.MIN_VALUE);
		t0.add(10);
		t0.add(-10);
		t0.add(20);
		t0.add(null);

		List<Integer> l0 = t0.inOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(Integer.MIN_VALUE);
		l1.add(-10);
		l1.add(10);
		l1.add(20);
		l1.add(Integer.MAX_VALUE);
		l1.add(null);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void postOrderTest1() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(10);
		t0.add(-5);
		t0.add(15);
		t0.add(20);
		t0.add(-15);
		t0.add(null);

		List<Integer> l0 = t0.postOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-15);
		l1.add(-5);
		l1.add(null);
		l1.add(20);
		l1.add(15);
		l1.add(10);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void postOrderTest2() {
		BST<Integer> t0 = new BST<Integer>();
		t0.add(Integer.MAX_VALUE);
		t0.add(null);
		t0.add(Integer.MIN_VALUE);
		t0.add(15);
		t0.add(-15);
		t0.add(20);

		List<Integer> l0 = t0.postOrder();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-15);
		l1.add(20);
		l1.add(15);
		l1.add(Integer.MIN_VALUE);
		l1.add(null);
		l1.add(Integer.MAX_VALUE);

		assertEquals(l0, l1);
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void reconstructTest1() {
		BST<Integer> t = new BST<Integer>();
		List<Integer> preOrder = new ArrayList<Integer>();
		List<Integer> postOrder = new ArrayList<Integer>();

		preOrder.add(1);
		preOrder.add(-5);
		preOrder.add(-6);
		preOrder.add(-4);
		preOrder.add(5);
		preOrder.add(4);
		preOrder.add(6);

		postOrder.add(-6);
		postOrder.add(-4);
		postOrder.add(-5);
		postOrder.add(4);
		postOrder.add(6);
		postOrder.add(5);
		postOrder.add(1);

		t.reconstruct(preOrder, postOrder);
		assertTrue(t.contains(1));
		assertTrue(t.contains(-5));
		assertTrue(t.contains(-6));
		assertTrue(t.contains(-4));
		assertTrue(t.contains(5));
		assertTrue(t.contains(4));
		assertTrue(t.contains(6));
		assertEquals(preOrder.size(), t.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void reconstructTest2() {
		BST<Integer> t = new BST<Integer>();
		List<Integer> preOrder = new ArrayList<Integer>();
		List<Integer> postOrder = new ArrayList<Integer>();

		preOrder.add(1);
		preOrder.add(-3);
		preOrder.add(-9);
		preOrder.add(9);
		preOrder.add(null);

		postOrder.add(-9);
		postOrder.add(-3);
		postOrder.add(1);
		postOrder.add(9);
		postOrder.add(null);

		t.reconstruct(preOrder, postOrder);
		assertTrue(t.contains(1));
		assertTrue(t.contains(-3));
		assertTrue(t.contains(-9));
		assertTrue(t.contains(9));
		assertTrue(t.contains(null));
		assertEquals(preOrder.size(), t.size());
	}

	@After
	public void teardown() {
		bst = null;
		avl = null;
	}
}