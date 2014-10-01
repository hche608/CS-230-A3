package universityTest;


import university.Enrolments;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.Assert;


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
	
	@Test(expected = IllegalArgumentException.class)
	public void testForExceptionsGivenNgtiveIntegerID() {
		myApp.enrolStudentInPaper(-100, "Geol01");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testForExceptionsGivenZeroID() {
		myApp.enrolStudentInPaper(0, "Geol01");
	}
	
	@Test	
	public void testInvalidStudentEnrolledInValidPaperFailsCase1() {
		assertFalse("\nEnrol should fail for student -100 and paper 'Geol01'", myApp.enrolStudentInPaper(-100, "Geol01"));
	}	

	@Test	
	public void testInvalidStudentEnrolledInValidPaperFailsCase2() {
		assertFalse("\nEnrol should fail for student 100 and paper 'Geol02'", myApp.enrolStudentInPaper(100, "Geol02"));
	}	
	
	@Test
	public void testInvalidStudentEnrolledInValidPaperStudentHasOnePaperCase1() {
		myApp.enrolStudentInPaper(-100, "Geol01");
		assertFalse("Student -100 should not have paper Geol01", myApp.listPapersForStudent(-100).contains("Geol01"));		
		assertFalse("Paper Geol01 should not have student -100", myApp.listStudentIdsForPaper("Geol01").contains(-100));		
	}
	
	@Test
	public void testInvalidStudentEnrolledInValidPaperStudentHasOnePaperCase2() {
		myApp.enrolStudentInPaper(0, "Geol01");
		assertFalse("Student -100 should not have paper Geol01", myApp.listPapersForStudent(0).contains("Geol01"));		
		assertFalse("Paper Geol01 should not have student -100", myApp.listStudentIdsForPaper("Geol01").contains(0));		
	
	}
	
	@Test
	public void testInvalidStudentEnrolledInValidPaperStudentHasOnePaperCase3() {	
		myApp.enrolStudentInPaper(100, "Geol01");
		assertFalse("Student -100 should not have paper Geol01", myApp.listPapersForStudent(100).contains("Geol01"));		
		assertFalse("Paper Geol01 should not have student -100", myApp.listStudentIdsForPaper("Geol01").contains(100));		
	}
	
	
	
	// Enrol a valid student in an invalid paper
	
	
	@Test(expected = NullPointerException.class)
	public void testForExceptionsGivenNULLPaperName() {
		myApp.enrolStudentInPaper(2044, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testForExceptionsGivenEmptyPaperName() {
		myApp.enrolStudentInPaper(2044, "");
	}
	
	
	// Enrol an invalid student in an invalid paper
	
	@Test(expected = NullPointerException.class)
	public void testForExceptionsGivenNgtiveIntegerIDAndNULLPaperName() {
		myApp.enrolStudentInPaper(-100, null);
	}
	/*
	@Test(expected = Error.class)
	public void testForExceptionsGivenString() {
		myApp.enrolStudentInPaper("100", "Math01");
	}
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testForExceptionsGivenZeroIDAndEmptyPaperName() {
		myApp.enrolStudentInPaper(0, "");
	}
			
	
	@Test
	public void testInvalidStudentEnrolledInInvalidPaperFailsCase2() {
		assertFalse("Enrol should unsucceed for student -100 and paper \"\"", myApp.enrolStudentInPaper(-100, ""));		
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
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaperBoundaryValues() {
		myApp.enrolStudentInPaper(1011, "Geol01");
		assertTrue("Student 1011 should have paper Geol01", myApp.listPapersForStudent(1011).contains("Geol01"));		
		assertTrue("Paper Geol01 should have student 1011", myApp.listStudentIdsForPaper("Geol01").contains(1011));		
	
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
	
	
	// --- VALID PARAMETERS - INVALID USAGE ---

	// Enrol a valid student in a valid paper
	@Test
	public void testValidStudentEnrolledInValidPaperSucceedsInvalidUsageCase1() {
		assertFalse("Enrol should fail for student 100 and paper 'Geol01'", myApp.enrolStudentInPaper(100, "Geol01"));
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperSucceedsInvalidUsageCae2() {
		assertTrue("Enrol should succeed for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
		assertFalse("Enrol should succeed for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
	}

	// 1 student 5 papers
	@Test
	public void testValidStudentEnrolledInValidPaperSucceedsInvalidUsageCae3() {
		assertTrue("Enrol should succeed for student 1011 and paper 'Math01'", myApp.enrolStudentInPaper(1011, "Math01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Phys01'", myApp.enrolStudentInPaper(1011, "Phys01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Chem01'", myApp.enrolStudentInPaper(1011, "Chem01"));
		assertTrue("Enrol should succeed for student 1011 and paper 'Biol01'", myApp.enrolStudentInPaper(1011, "Biol01"));
		assertFalse("Enrol should fail for student 1011 and paper 'Geol01'", myApp.enrolStudentInPaper(1011, "Geol01"));
	}
	
	@Test
	public void testValidStudentEnrolledInValidPaperStudentHasOnePaperInvalidUsage() {
		myApp.enrolStudentInPaper(100, "Geol01");
		assertFalse("Student 100 should have paper Geol01", myApp.listPapersForStudent(100).contains("Geol01"));		
		assertFalse("Paper Geol01 should have student 100", myApp.listStudentIdsForPaper("Geol01").contains(100));		
	}
	
	

}
