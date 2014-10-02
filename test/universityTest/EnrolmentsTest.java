package universityTest;

import university.Enrolments;
import junit.framework.TestCase;

import org.junit.Test;

public class EnrolmentsTest extends TestCase {

	Enrolments myApp;
	
	protected void setUp() throws Exception {
		super.setUp();
		myApp = new Enrolments();
	}

	protected void tearDown() throws Exception {
        super.tearDown();
	}

	
	// --- INVALID PARAMETERS ---
	
	// Enrol an invalid student in a valid paper
	
	@Test
	public void testForExceptionsGivenNgtiveIntegerID() {
		try {
			myApp.enrolStudentInPaper(-100, "Geol01");
			fail("Expected IllegalArgumentException when 1st argu is negative");
		} catch (IllegalArgumentException e){
			//passed the test
		}		
	}
				
	@Test
	public void testForExceptionsGivenZeroID() {
		try {
			myApp.enrolStudentInPaper(0, "Geol01");
			fail("Expected IllegalArgumentException when 1st argu is zero");
		} catch (IllegalArgumentException e){
			//passed the test
		}
	}
	
	@Test
	public void testForExceptionsGivenInvalidPara() {
		try {
			myApp.enrolStudentInPaper(000, "Geol01");
			fail("Expected IllegalArgumentException when 1st argu is zero");
		} catch (IllegalArgumentException e){
			//passed the test
		}
	}
	
	// Enrol a valid student in an invalid paper
	
	@Test
	public void testForExceptionsGivenNULLPaperName() {
		try {
			myApp.enrolStudentInPaper(2044, null);
			fail("Expected NullPointerException when 2nd argu is null");
		} catch (NullPointerException e){
			//passed the test
		}
	}
	
	@Test
	public void testForExceptionsGivenEmptyPaperName() {
		try {
			myApp.enrolStudentInPaper(2044, "");
			fail("Expected IllegalArgumentException when 2nd argu is empty");
		} catch (IllegalArgumentException e){
			//passed the test
		}
	}
	
	// Enrol an invalid student in an invalid paper
	
	@Test
	public void testForExceptionsGivenNgtiveIntegerIDEmptyPaper() {
		try {
			myApp.enrolStudentInPaper(-100, "");
			fail("Expected IllegalArgumentException when 1st argu is negative");
		} catch (IllegalArgumentException e){
			//passed the test
		}
	}
		
	@Test
	public void testForExceptionsGivenNgtiveIntegerIDNullPaper() {
		try {
			myApp.enrolStudentInPaper(0, null);
			fail("Expected IllegalArgumentException when 1st argu is negative");
		} catch (IllegalArgumentException e){
			//passed the test
		}
	}
		
	// --- VALID PARAMETERS - BOUNDARY VALUES ---
	
	// Enrol a valid student in a valid paper
	@Test
	public void testValidStudentEnrolledInValidPaperSucceedsBoundaryValuesCase1() {
		assertTrue("Enrol should succeed for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
	}
		
	@Test
	public void testValidStudentEnrolledInValidPaperSucceedsBoundaryValuesCase2() {
		assertTrue("Enrol should succeed for student 2044 and paper 'Math01'", myApp.enrolStudentInPaper(2044, "Math01"));
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaperBoundaryValuesCase1() {
		myApp.enrolStudentInPaper(1011, "Geol01");
		assertTrue("Student 1011 should have paper Geol01", myApp.listPapersForStudent(1011).contains("Geol01"));		
		assertTrue("Paper Geol01 should have student 1011", myApp.listStudentIdsForPaper("Geol01").contains(1011));		
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaperBoundaryValuesCase2() {
		myApp.enrolStudentInPaper(2044, "Math01");
		assertTrue("Student 2044 should have paper Math01", myApp.listPapersForStudent(2044).contains("Math01"));		
		assertTrue("Paper Math01 should have student 2044", myApp.listStudentIdsForPaper("Math01").contains(2044));		
	}

	// --- VALID PARAMETERS - MID-RANGE ---
	
	// Enrol a valid student in a valid paper
	@Test
	public void testValidStudentEnrolledInValidPaperSucceeds() {
		assertTrue("Enrol should succeed for student 2135 and paper 'Phys01'", myApp.enrolStudentInPaper(2135, "Phys01"));
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaper() {
		myApp.enrolStudentInPaper(2135, "Phys01");
		assertTrue("Student 2135 should have paper Phys01", myApp.listPapersForStudent(2135).contains("Phys01"));		
		assertTrue("Paper Phys01 should have student 2135", myApp.listStudentIdsForPaper("Phys01").contains(2135));		
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasPapers() {
		myApp.enrolStudentInPaper(2135, "Phys01");
		assertTrue("Student 2135 should have paper Phys01", myApp.listPapersForStudent(2135).contains("Phys01"));		
		assertTrue("Paper Phys01 should have student 2135", myApp.listStudentIdsForPaper("Phys01").contains(2135));		
		
		myApp.enrolStudentInPaper(2135, "Math01");
		assertTrue("Student 2135 should have paper Math01", myApp.listPapersForStudent(2135).contains("Math01"));		
		assertTrue("Paper Math01 should have student 2135", myApp.listStudentIdsForPaper("Math01").contains(2135));	
		
		myApp.enrolStudentInPaper(2135, "Biol01");
		assertTrue("Student 2135 should have paper Biol01", myApp.listPapersForStudent(2135).contains("Biol01"));		
		assertTrue("Paper Biol01 should have student 2135", myApp.listStudentIdsForPaper("Biol01").contains(2135));	
		
		myApp.enrolStudentInPaper(2135, "Chem01");
		assertTrue("Student 2135 should have paper Chem01", myApp.listPapersForStudent(2135).contains("Chem01"));		
		assertTrue("Paper Chem01 should have student 2135", myApp.listStudentIdsForPaper("Chem01").contains(2135));	
		
		
		System.out.println(myApp.listPapersForStudent(2135));
		assertEquals(myApp.listPapersForStudent(2135).get(0), "Phys01");
		assertEquals(myApp.listPapersForStudent(2135).get(1), "Math01");
		assertEquals(myApp.listPapersForStudent(2135).get(2), "Biol01");
		assertEquals(myApp.listPapersForStudent(2135).get(3), "Chem01");
		
	}
	
	
	// --- VALID PARAMETERS - INVALID USAGE ---

	// Enrol a valid student in a valid paper
	@Test
	public void testValidStudentEnrolledInValidPaperFailsInvalidUsageCase1() {
		assertFalse("Enrol should fail for student 100 and paper 'Geol01'", myApp.enrolStudentInPaper(100, "Geol01"));
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperFailsInvalidUsageCae2() {
		assertTrue("Enrol should succeed for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
		assertFalse("Enrol should fail for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
	}

	// 1 student 5 papers
	@Test
	public void testValidStudentEnrolledInValidPaperFailsInvalidUsageCae3() {
		assertTrue("Enrol should succeed for student 1011 and paper 'Math01'", myApp.enrolStudentInPaper(1011, "Math01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Phys01'", myApp.enrolStudentInPaper(1011, "Phys01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Chem01'", myApp.enrolStudentInPaper(1011, "Chem01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Biol01'", myApp.enrolStudentInPaper(1011, "Biol01"));
		assertFalse("Enrol should fail for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
	}
	
	
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaperInvalidUsage() {
		myApp.enrolStudentInPaper(100, "Geol01");
		assertFalse("Enrol should fail for student 100 and paper 'Geol01'", myApp.enrolStudentInPaper(100, "Geol01"));
		assertFalse("Student 100 should have paper Geol01", myApp.listPapersForStudent(100).contains("Geol01"));		
		assertFalse("Paper Geol01 should have student 100", myApp.listStudentIdsForPaper("Geol01").contains(100));		
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperFailsInvalidUsageCae4() {
		assertFalse("Enrol should succeed for student 333 and paper 'Geol01'", myApp.enrolStudentInPaper(333, "Geol01"));
		assertFalse("Enrol should fail for student 33333 and paper 'Geol01'", myApp.enrolStudentInPaper(3333, "Geol01"));
	}

}
