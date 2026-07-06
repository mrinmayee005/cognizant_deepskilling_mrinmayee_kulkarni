import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import cohortData from './CohortData';

describe("Cohort Details Component", () => {
  test("should create the component", () => {
    const wrapper = shallow(<CohortDetails cohort={cohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test("should initialize the props", () => {
    const wrapper = mount(<CohortDetails cohort={cohortData[1]} />);
    expect(wrapper.props().cohort).toEqual(cohortData[1]);
  });

  test("should display cohort code in h3", () => {
    const wrapper = mount(<CohortDetails cohort={cohortData[0]} />);
    expect(wrapper.find('h3').text()).toBe('CS101');
  });

  test("should always render same html", () => {
    const wrapper = shallow(<CohortDetails cohort={cohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});