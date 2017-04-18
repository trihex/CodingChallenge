import { CodingchallengePage } from './app.po';

describe('codingchallenge App', () => {
  let page: CodingchallengePage;

  beforeEach(() => {
    page = new CodingchallengePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
